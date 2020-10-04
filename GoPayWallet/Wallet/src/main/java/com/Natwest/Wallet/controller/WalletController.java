package com.Natwest.Wallet.controller;


import com.Natwest.Wallet.exception.InsufficientFundExeption;
import com.Natwest.Wallet.exception.TransactionFailedException;
import com.Natwest.Wallet.model.Card;
import com.Natwest.Wallet.model.Transaction;
import com.Natwest.Wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transaction/")
@CrossOrigin
@EnableFeignClients
public class WalletController {

    private WalletService walletService;
    private ResponseEntity responseEntity;
    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PutMapping("/walletUser")
    public ResponseEntity<?> createWalletUser(@RequestParam(value="userId", required=true) String userId,
                                              @RequestParam(value="nameOnCard", required=true) String nameOnCard,
                                              @RequestParam(value="expiryDate", required=true) String expiryDate,
//                                              @RequestParam(value="cvv", required=true) String cvv,
                                              @RequestParam(value="cardNumber", required=true) String cardNumber

    )  {
        try {
            if(walletService.createWalletUser(userId,nameOnCard,expiryDate,null,cardNumber)){
                responseEntity = new ResponseEntity(true, HttpStatus.CREATED);
            }
            else{
                responseEntity = new ResponseEntity(false, HttpStatus.valueOf(409));
            }

        }  catch (Exception e)
        {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/debit")
    public ResponseEntity<?> debitTransaction(@RequestParam(value="userId", required=true) String userId,
                                              @RequestParam(value="amount", required=true) double amount,
                                              @RequestParam(value="currency", required=true) String currency
                                              )  {
        try{
            walletService.debit(userId,amount,currency);
            responseEntity = new ResponseEntity(true, HttpStatus.OK);
        } catch (InsufficientFundExeption e)
        {
            responseEntity = new ResponseEntity("Insufficient Funds" , HttpStatus.NOT_FOUND);
        } catch (TransactionFailedException e){
            responseEntity = new ResponseEntity("Transaction Failed" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/credit")
    public ResponseEntity<?> creditTransaction(@RequestParam(value="userId", required=true) String userId,
                                              @RequestParam(value="amount", required=true) double amount,
                                              @RequestParam(value="currency", required=true) String currency
    )  {
        try{
            walletService.credit(userId,amount,currency);
            responseEntity = new ResponseEntity(true, HttpStatus.OK);
        } catch (TransactionFailedException e){
            responseEntity = new ResponseEntity("Transaction Failed" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/wallet")
    public ResponseEntity<?> getWalletAmount(@RequestParam(value="userId", required=true) String userId)  {
        try {
            Map<String,Double> walletAmount = walletService.getWallet(userId);
            responseEntity = new ResponseEntity(walletAmount, HttpStatus.OK);
        }catch (TransactionFailedException e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTransactions(@RequestParam(value="userId", required=true) String userId)  {
        try {
            List<Transaction> transactionList = walletService.getAllTransactionByUserId(userId);
            responseEntity = new ResponseEntity(transactionList, HttpStatus.OK);
        }catch (TransactionFailedException e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/card")
    public ResponseEntity<?> getCard(@RequestParam(value="userId", required=true) String userId)  {
        try {
            Card card= walletService.getCardByUserId(userId);
            responseEntity = new ResponseEntity(card, HttpStatus.OK);
        }catch (TransactionFailedException e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
//http://localhost:8083/api/v1/transaction/all?userId=1
//http://localhost:8083/api/v1/transaction/debit?userId=1&amount=1000&currency=C2
//http://localhost:8083/api/v1/transaction/walletUser?userId=1