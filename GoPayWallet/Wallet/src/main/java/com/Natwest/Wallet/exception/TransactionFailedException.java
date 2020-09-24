package com.Natwest.Wallet.exception;

public class TransactionFailedException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public TransactionFailedException(String message)
	{
		super(message);
	}
}
