package com.csci306.solidspring.restservice.coins;


public class BitcoinRobust extends Bitcoin {
	private static final double BTC_USD = 18656;
	private static final double TRANSACTION_FEE_USD = 11.66;
	
	private static BitcoinRobust bitcoinRobust = new BitcoinRobust();

	private BitcoinRobust() { }
	
	public static BitcoinRobust getInstance() 
	{
		return bitcoinRobust;
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
	public BitcoinRobust processTransaction( double requestedBTC ) throws Exception
	{
		if( (fBTC + requestedBTC) * BTC_USD - TRANSACTION_FEE_USD < 0 )
		{
			throw new Exception(String.format("\nInsufficient funds:" +
		"\n\t BTC Available: %1$s\n\t BTC Requested: %2$s\n\t BTC Transation Fee (USD): %3$s",
					fBTC, requestedBTC, TRANSACTION_FEE_USD));
		} else {
			fBTC = fBTC + requestedBTC - (TRANSACTION_FEE_USD / BTC_USD);
		}
		
		return this;
	}
	
	/////////////////////////////////////////
	//	For Serialization
	////////////////////////////////////////	
	public double getTransactionFeeUSD()
	{
		return TRANSACTION_FEE_USD;
	}
}
