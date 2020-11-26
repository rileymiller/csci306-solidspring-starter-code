package com.csci306.solidspring.restservice.wallet;

import com.csci306.solidspring.restservice.coins.Bitcoin;
import com.csci306.solidspring.restservice.coins.BitcoinRobust;

public class DigitalWallet {
	
	private BitcoinRobust btc = BitcoinRobust.getInstance();
	
	private static DigitalWallet wallet = new DigitalWallet();
	
	private DigitalWallet() { };
	
	public static DigitalWallet getInstance()
	{
		return wallet;
	}
	
	public Bitcoin processTransaction( double amount ) throws Exception
	{
		return btc.processTransaction( amount );
	}
	
	public Bitcoin zero()
	{
		return btc.setZero();
	}
	
	public Bitcoin accountBalance()
	{
		return btc.accountBalance();
	}

}
