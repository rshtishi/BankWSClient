package com.github.rshtishi.bankwsclient.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rshtishi.bankwsclient.entity.Balance;
import com.github.rshtishi.bankwsclient.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankRestController {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/{client}")
	public Balance findBalanceForClient(@PathVariable String client) {
		return bankService.computeBalanceForClient(client);
	}
	
}
