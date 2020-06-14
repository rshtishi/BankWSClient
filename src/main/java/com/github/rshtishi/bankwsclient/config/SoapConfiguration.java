package com.github.rshtishi.bankwsclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("com.github.rshtishi.bankws.soap.client.bankws");
		return marshaller;
	}
	
	@Bean
	public SoapProperties soapProperties() {
		return new SoapProperties();
	}

}
