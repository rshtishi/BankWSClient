package com.github.rshtishi.bankwsclient.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SoapPropertiesTest {
	
	@Autowired
	private SoapProperties soapProperties;

	@Test
	void testGetEndpointUrl() {
		//setup
		String expectedUrl = "http://localhost:8888/baws";
		//execute
		String actualUrl = soapProperties.getEndpoint().getUrl();
		//verify
		assertEquals(expectedUrl, actualUrl);
	}

}
