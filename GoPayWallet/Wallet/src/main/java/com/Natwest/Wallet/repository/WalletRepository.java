package com.Natwest.Wallet.repository;

import com.Natwest.Wallet.model.WalletUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

/*
 * This class is implementing the MongoRepository interface for Note.
 * Annotate this class with @Repository annotation
 * */
@Repository
public interface WalletRepository extends MongoRepository<WalletUser, String> {

}
