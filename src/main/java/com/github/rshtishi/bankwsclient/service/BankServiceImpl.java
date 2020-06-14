package com.github.rshtishi.bankwsclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rshtishi.bankws.soap.client.bankws.ActionType;
import com.github.rshtishi.bankws.soap.client.bankws.Transaction;
import com.github.rshtishi.bankwsclient.client.BankWSClient;
import com.github.rshtishi.bankwsclient.entity.Balance;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankWSClient bankwsClient;

	@Override
	public Balance computeBalanceForClient(String client) {
		Balance balance = new Balance();
		balance.setClient(client);
		balance.setBalance(0);
		bankwsClient.getTransactionsForClient(client).getValue().getReturn().forEach(transaction -> addTransaction(balance,transaction) );
		return balance;
	}

	private void addTransaction(Balance balance,Transaction transaction) {
		if(transaction.getActionType().value().equals(ActionType.DEPOSIT.value()) ){
			balance.setBalance(balance.getBalance()+transaction.getAmount());
		} else {
			balance.setBalance(balance.getBalance()-transaction.getAmount());
		}
	}

}
