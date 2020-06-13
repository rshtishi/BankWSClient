package com.github.rshtishi.bankwsclient.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactionsForClient;
import com.github.rshtishi.bankws.soap.client.bankws.Transaction;
import com.github.rshtishi.bankwsclient.client.BankWSClient;

@RestController
@RequestMapping("bankws")
public class BankWSRestController {
	
	@Autowired
	private BankWSClient client;

	@PostMapping
	public List<Transaction> getTransaction(@RequestBody GetTrasactionsForClient request) {
		//return client.getTransaction(request);
		return null;
	}

}
