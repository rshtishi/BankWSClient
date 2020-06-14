package com.github.rshtishi.bankwsclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "soap")
public class SoapProperties {
	
	private Endpoint endpoint = new Endpoint();

	@Data
	public static class Endpoint {
		private String url;
	}
}
