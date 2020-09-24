package com.Natwest.Wallet.service;

import com.Natwest.Wallet.exception.InsufficientFundExeption;
import com.Natwest.Wallet.exception.TransactionFailedException;
import com.Natwest.Wallet.model.Transaction;
import com.Natwest.Wallet.model.WalletUser;

import java.util.List;
public interface WalletService {
    boolean createWalletUser(String userId);

    boolean debit(String userId, double amount,String currency) throws TransactionFailedException, InsufficientFundExeption;

    boolean credit(String userId, double amount,String currency) throws TransactionFailedException;


//    Note updateNote(Note note, int id, String userId) throws NoteNotFoundExeption;
//
//    Note getNoteByNoteId(String userId,int noteId) throws NoteNotFoundExeption;

    List<Transaction> getAllTransactionByUserId(String userId) throws TransactionFailedException;
}
