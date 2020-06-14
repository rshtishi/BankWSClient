package com.github.rshtishi.bankwsclient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.rshtishi.bankwsclient.entity.Balance;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BankServiceImplTest {
	
	@Autowired
	private BankService bankService;

	@Test
	void testComputeBalanceForClient() {
		//setup
		String expectedClient = "rshtishi";
		double expectedBalance = 1200.00;
		//execute
		Balance balance = bankService.computeBalanceForClient(expectedClient);
		//verify
		assertEquals(expectedClient,balance.getClient());
		assertEquals(expectedBalance,balance.getBalance());
	}

}
