package com.Natwest.Wallet.exception;

public class InsufficientFundExeption extends Exception {
   
	private static final long serialVersionUID = 1L;

	public InsufficientFundExeption(String message) {
        super(message);
    }
}
