package com.casino.provide.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.casino.provide.request.RequestSimulatedGameProvide;
import com.casino.provide.utility.SignatureUseful;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProvaderGameServiceImpl implements ProvaderGameService {

	private static final Logger logger = LoggerFactory.getLogger(ProvaderGameServiceImpl.class);
	
	
	@Value("${sbpg.init.gamelaunchUrl}")
	private String gamelaunchUrl;
	
	/****
	 * In this code, the generateSignature method takes in a message and a secretKey, 
	 * generates a SHA1 hash of the message, 
	 * generates an HMAC-SHA1 signature using the secret key and the SHA1 hash, 
	 * and then encodes the signature as a Base64 string.  
	 * @throws SignatureException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws InvalidKeySpecException 
	 */
	@Override
	public String generateSignature(String message, String secretKey) throws SignatureException 
			{
		logger.debug("START - generateSignature ");
		String signature = SignatureUseful.getSignature(message, secretKey);
	    logger.debug("END - generateSignature ");
	    return signature;
	
	}
	
	@Override
	public String signature(String message, String secretKey) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException {
		String signature="";
			signature = SignatureUseful.signature(message, secretKey);
		
		return signature;
	}

	@Override
	public String gamelaunchProvider(RequestSimulatedGameProvide requestBody) throws URISyntaxException, IOException, InterruptedException 
	{ 
		 logger.info("START : gamelaunchProvider");
		 logger.info(gamelaunchUrl);
		 String payload = asJsonString(requestBody);
		 logger.info("gamelaunchProvider -> payload : " + payload);
		 HttpRequest request = HttpRequest.newBuilder()
					 .uri(URI.create(gamelaunchUrl))
					 .header(HttpHeaders.ACCEPT, "application/json")
					 .header(HttpHeaders.CONTENT_TYPE, "application/json")
					 .POST(HttpRequest.BodyPublishers.ofString(payload))
					 .build();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> responseBody = client.send(request, BodyHandlers.ofString());
		
		logger.info("END : gamelaunchProvider");
		return responseBody.body();
		 
	}
	 
	@Override
	public String calculateSignature(String message, String secretKey)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
		{
			return SignatureUseful.calculateSignature(message);
		}

	@Override
	public String getSignature(String message, String secretKey) throws SignatureException {
		logger.debug("START - getSignature ");
		String signature = SignatureUseful.getSignature(message, secretKey);
	    logger.debug("END - getSignature ");
		return signature;
	 }

	@Override
	public String getSignatureWithKey(String message, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
		logger.debug("START - getSignature ");
		String signature = SignatureUseful.getSignatureWithKey(message, secretKey);
	    logger.debug("END - getSignature ");
	    return signature;
	}

	

	
	/***
	 * 
	 * @param obj
	 * @return
	 */
	private String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
