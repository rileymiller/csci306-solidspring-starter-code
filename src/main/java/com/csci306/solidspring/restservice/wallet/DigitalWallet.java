package com.csci306.solidspring.restservice.wallet;

public class DigitalWallet {
	
	private static DigitalWallet wallet = new DigitalWallet();
	
	private static final String fName = "Bitcoin";
	private static final String fWhitePaper = "https://bitcoin.org/bitcoin.pdf";
	private double fBTC = 0;
	
	private DigitalWallet() { };
	
	public static DigitalWallet getInstance()
	{
		return wallet;
	}
	
	
	public DigitalWallet processTransaction( double amount ) throws Exception
	{
		if( fBTC + amount < 0 )
		{
			throw new Exception(String.format("\nInsufficient funds:\n\t BTC Available: %1$s\n\t BTC Requested: %2$s", fBTC, amount));
		} else {
			fBTC = fBTC + amount;
		}
		
		return this;
	}
	
	public DigitalWallet zero()
	{
		fBTC = 0;
		
		return this;
	}
	
	public DigitalWallet accountBalance()
	{
		return this;
	}
	
	/////////////////////////////////////////
	//	For Serialization
	////////////////////////////////////////
	public double getBTC() 
	{
		return fBTC;
	}
	
	public String getName()
	{
		return fName;
	}
	
	public String getWhitePaper()
	{
		return fWhitePaper;
	}
	
	public double getSatoshis()
	{
		return fBTC * 100000000;
	}

}
