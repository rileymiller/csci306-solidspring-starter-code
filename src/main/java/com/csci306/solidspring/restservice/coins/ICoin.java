package com.csci306.solidspring.restservice.coins;

public interface ICoin {
	ICoin processTransaction( double amount );
	
	ICoin setZero();
	
	ICoin accountBalance();
}
