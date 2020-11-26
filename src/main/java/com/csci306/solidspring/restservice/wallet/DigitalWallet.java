package com.csci306.solidspring.restservice.wallet;

import com.csci306.solidspring.restservice.coins.ICoin;

public class DigitalWallet {
	private static DigitalWallet wallet = new DigitalWallet();
	
	private DigitalWallet() { };
	
	public static DigitalWallet getInstance()
	{
		return wallet;
	}
	
	
	public ICoin processTransaction( ICoin coin, double amount ) throws Exception
	{
		return coin.processTransaction( amount );
	}
	
	public ICoin zero( ICoin coin )
	{
		return coin.setZero();
	}
	
	public ICoin accountBalance( ICoin coin )
	{
		return coin.accountBalance();
	}
}
