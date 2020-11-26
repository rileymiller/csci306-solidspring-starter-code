package com.csci306.solidspring.restservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.csci306.solidspring.restservice.coins.Bitcoin;
import com.csci306.solidspring.restservice.coins.BitcoinRobust;
import com.csci306.solidspring.restservice.coins.ICoin;
import com.csci306.solidspring.restservice.wallet.DigitalWallet;

@RestController
public class DigitalWalletController {
	
	private BitcoinRobust btc = BitcoinRobust.getInstance();
	
	@GetMapping("/balance")
	public ICoin wallet() {
		try 
		{	
			return DigitalWallet
					.getInstance()
					.accountBalance( btc );
		} catch (Exception e)
		{
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, e.toString() );
			
		}
	}
	
	@GetMapping("/transaction")
	public ICoin transaction(
			@RequestParam(value = "value", defaultValue = "0" )
			String value ) throws Exception
	{
		try
		{
			double parsedValue = Double.parseDouble( value );
			
			return DigitalWallet
					.getInstance()
					.processTransaction( btc, parsedValue );
			
		} 
		catch ( NumberFormatException e )
		{
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.toString() );
		}
	}
	
	@GetMapping("/zero")
	public ICoin zero()
	{
		return DigitalWallet
				.getInstance()
				.zero( btc );
	}
}