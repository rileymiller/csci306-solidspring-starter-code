package com.csci306.solidspring.restservice.coins;

public class Bitcoin {
	private static final String fName = "Bitcoin";
	private static final String fWhitePaper = "https://bitcoin.org/bitcoin.pdf";
	private double fBTC = 0;
	
	private static Bitcoin bitcoin = new Bitcoin();
	
	private Bitcoin() { };
	
	public static Bitcoin getInstance() 
	{
		return bitcoin;
	}
	
	/**
	 * Processes a BTC transaction in the digital wallet by adding
	 * or removing BTC. If the call tries to deduct more funds than
	 * are available in the wallet, it throws an error.
	 * 
	 * @param requestedBTC
	 * @return this
	 * @throws Exception
	 */
	public Bitcoin processTransaction( double requestedBTC ) throws Exception
	{
		if( fBTC + requestedBTC < 0 )
		{
			throw new Exception(String.format("\nInsufficient funds:\n\t BTC Available: %1$s\n\t BTC Requested: %2$s", fBTC, requestedBTC));
		} else {
			fBTC = fBTC + requestedBTC;
		}
		
		return this;
	}
	
	/**
	 * Sets the BTC balance to zero
	 * 
	 * @return this
	 */
	public Bitcoin setZero()
	{
		fBTC = 0;
		
		return this;
	}
	
	/**
	 * Returns the BTC balance in the Digital Wallet
	 * 
	 * @return this
	 */
	public Bitcoin accountBalance()
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
