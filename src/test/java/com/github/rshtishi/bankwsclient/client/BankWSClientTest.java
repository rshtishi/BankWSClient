package com.github.rshtishi.bankwsclient.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.bind.JAXBElement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactionsForClientResponse;
import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactionsResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BankWSClientTest {

	@Autowired
	private BankWSClient client;

	@Test
	public void testGetAllTransactions() {
		// setup
		int sizeExpected = 5;
		// execute
		JAXBElement<GetTrasactionsResponse> response = client.getAllTransactions();
		// verify
		assertEquals(sizeExpected, response.getValue().getReturn().size());
	}
	
	@Test
	public void testGetTransactionForClient() {
		//setup
		int idExpected = 1;
		String clientExpected = "rshtishi";
		double amountExpected = 500.00;
		//execute
		JAXBElement<GetTrasactionsForClientResponse> response = client.getTransactionsForClient(clientExpected);
		//verify
		assertEquals(idExpected,response.getValue().getReturn().get(0).getId());
		assertEquals(clientExpected,response.getValue().getReturn().get(0).getClient());
		assertEquals(amountExpected,response.getValue().getReturn().get(0).getAmount());
	}
	

}
