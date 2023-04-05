package com.casino.provide.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;

import com.casino.provide.request.RequestSimulatedGameProvide;

public interface ProvaderGameService {
 	
	/***
	 * 
	 * @param message
	 * @param privateKey
	 * @return
	 * @throws SignatureException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	String generateSignature(String message, String privateKey)  throws SignatureException, NoSuchAlgorithmException, InvalidKeyException ;
	
	/***
	 * 
	 * @param message
	 * @param secretKey
	 * @return
	 * @throws SignatureException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	String calculateSignature(String message, String secretKey)  throws SignatureException, NoSuchAlgorithmException, InvalidKeyException ;
	
	/***
	 * 
	 * @param message
	 * @param secretKey
	 * @return
	 * @throws SignatureException
	 */
	String getSignature(String message, String secretKey) throws SignatureException;
	
	/***
	 * 
	 * @param message
	 * @param secretKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	String getSignatureWithKey(String message, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException;
	
	/***
	 * 
	 * @param requestSimulatedGameProvide
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	String gamelaunchProvider(RequestSimulatedGameProvide requestSimulatedGameProvide) throws URISyntaxException, IOException, InterruptedException ;

	
	String signature(String message, String secretKey ) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException;
	
}
