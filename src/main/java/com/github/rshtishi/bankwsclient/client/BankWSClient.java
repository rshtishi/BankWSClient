package com.github.rshtishi.bankwsclient.client;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactions;
import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactionsForClient;
import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactionsForClientResponse;
import com.github.rshtishi.bankws.soap.client.bankws.GetTrasactionsResponse;
import com.github.rshtishi.bankws.soap.client.bankws.ObjectFactory;
import com.github.rshtishi.bankws.soap.client.bankws.Transaction;

@Service
public class BankWSClient {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public JAXBElement<GetTrasactionsResponse> getAllTransactions() {
		template = new WebServiceTemplate(marshaller);
		ObjectFactory factory = new ObjectFactory();
		GetTrasactions getTransactions = factory.createGetTrasactions();
		JAXBElement<GetTrasactions> request = factory.createGetTrasactions(getTransactions);
		JAXBElement<GetTrasactionsResponse> response = (JAXBElement<GetTrasactionsResponse>) template
				.marshalSendAndReceive("http://localhost:8888/baws", request);
		return response;
	}

	public JAXBElement<GetTrasactionsForClientResponse> getTransactionsForClient(String client) {
		template = new WebServiceTemplate(marshaller);
		ObjectFactory factory = new ObjectFactory();
		GetTrasactionsForClient getTransactionsForClient = factory.createGetTrasactionsForClient();
		getTransactionsForClient.setArg0(client);
		JAXBElement<GetTrasactionsForClient> request = factory.createGetTrasactionsForClient(getTransactionsForClient);
		JAXBElement<GetTrasactionsForClientResponse> response = (JAXBElement<GetTrasactionsForClientResponse>) template
				.marshalSendAndReceive("http://localhost:8888/baws", request);
		return response;

	}
}
