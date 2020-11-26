package com.csci306.solidspring.restservice.coins;

public interface ICoin {
	ICoin processTransaction( double amount ) throws Exception;
	
	ICoin setZero();
	
	ICoin accountBalance();
}
