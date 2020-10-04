import { Component, OnInit } from '@angular/core';
import { Transaction } from '../classes/transaction';
import { LoginService } from '../services/login.service';
import { TransactionService } from '../services/transaction.service';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {

  transactionList: Transaction[];
  constructor(private transactionService: TransactionService, private loginService: LoginService) { }

  ngOnInit() {
    this.transactionService.getTransactionHistory(this.loginService.getUserId()).subscribe(
      data=>{
        //  console.log(data);
        console.log(data);
         this.transactionList = data;
        //  console.log(this.transactionList);
      },
      error=>{
        console.log(error);
      }
    )
  }

}
