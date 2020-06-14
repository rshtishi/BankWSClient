package com.github.rshtishi.bankwsclient.service;

import com.github.rshtishi.bankwsclient.entity.Balance;

public interface BankService {
	
	public Balance computeBalanceForClient(String client);

}
