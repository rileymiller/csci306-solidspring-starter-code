package com.csci306.solidspring.restservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.csci306.solidspring.restservice.coins.Bitcoin;
import com.csci306.solidspring.restservice.wallet.DigitalWallet;

@RestController
public class DigitalWalletController {

	@GetMapping("/balance")
	public Bitcoin wallet() {
		return DigitalWallet
				.getInstance()
				.accountBalance();
	}
	
	@GetMapping("/transaction")
	public Bitcoin transaction(
			@RequestParam(value = "value", defaultValue = "0" )
			String value ) 
	{
		try
		{
			double parsedValue = Double.parseDouble( value );
			
			try 
			{
				return DigitalWallet
						.getInstance()
						.processTransaction( parsedValue );
			}
			catch ( Exception e )
			{
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, e.toString() );
			}
			
		} 
		catch ( NumberFormatException e )
		{
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.toString() );
		}
	}
	
	@GetMapping("/zero")
	public Bitcoin zero()
	{
		return DigitalWallet
				.getInstance()
				.zero();
	}
}