package com.casino.provide.utility;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignatureUseful {
	private static final Logger logger = LoggerFactory.getLogger(SignatureUseful.class);
	
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	private static final String UTF = "UTF-8";
	private static final String SHA = "SHA-1";
	  

	public static String generateSignature(String message, String secretKey) {
		logger.debug("START -generateSignature ");
		
		String signature = null;
	    try {
	      System.err.println("secretKey: " + secretKey);
	      // Generate SHA1 hash of the message
	      MessageDigest digest  = MessageDigest.getInstance(SHA);
	      byte[] messageBytes = message.getBytes();
	      digest.update(messageBytes);
	      byte[] hashBytes  = digest.digest();

	      // Generate HMAC-SHA1 signature using the secret key
	      logger.debug("generateSignature - Generate HMAC-SHA1 signature using the secret key");
	      Mac hmac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
	      SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA1_ALGORITHM);
	      hmac.init(secretKeySpec);
	      byte[] signatureBytes = hmac.doFinal(hashBytes );

	      // Convert signature bytes to Base64 encoded string
	      logger.debug("generateSignature - Convert signature bytes to Base64 encoded string");
	      signature = Base64.getEncoder().encodeToString(signatureBytes);
	     
	    } catch (NoSuchAlgorithmException e) {
	      System.err.println("Error generating signature: " + e.getMessage());
	      return signature;
	    } catch (Exception e) {
	      System.err.println("Error generating signature: " + e.getMessage());
	      return signature;
	    }
	    
	    logger.debug("END -generateSignature ");
	    return signature;
	  }
	 
		public static String getSignature(String message, String secretKey) throws java.security.SignatureException {
			try {
				// get an hmac_sha1 key from the raw key bytes
				SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(UTF), HMAC_SHA1_ALGORITHM);
	
				// get an hmac_sha1 Mac instance and initialize with the signing key
				Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
				mac.init(signingKey);
	
				// compute the hmac on input data bytes
				byte[] rawHmac = mac.doFinal(message.getBytes(UTF));
				String result = Base64.getEncoder().encodeToString(rawHmac);
				return result;
	
			} catch (Exception e) {
				throw new SignatureException("Failed to generate HMAC : "+ e.getMessage());
			}
		}
		
		
		public static String  getSignatureWithKey(String input, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
			 
		      // create a SecretKeySpec object from the key
		      SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA1_ALGORITHM);

		      // create a MAC object with HmacSHA1 algorithm
		      Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		      mac.init(signingKey);

		      // calculate the digest of the data using the MAC object
		      byte[] digest = mac.doFinal(input.getBytes());

		      // encode the digest using Base64
		      String encodedSignature = getBase64EncodeToString(digest);
		      
		      return encodedSignature;
		}
		
		public static String encodeToBase64(String input) {
			 String encoded = "";
			  
		      try {
		         // Create MessageDigest instance for SHA1
		         MessageDigest md = MessageDigest.getInstance(SHA);
		         
		         // Add input string bytes to digest
		         md.update(input.getBytes());
		         
		         // Get the hash's bytes
		         byte[] bytes = md.digest();
		         
		         // Convert the hash's bytes to a Base64 encoded string
		         encoded = getBase64EncodeToString(bytes);
		         
		         // Print the encoded string
		         System.out.println("Encoded string: " + encoded);
		         
		      } catch (NoSuchAlgorithmException e) {
		         e.printStackTrace();
		         return encoded ;
		      }
		      
		      return encoded ;
		}
		
		public static String getEncodeToBase64(String input) throws NoSuchAlgorithmException {
			 String encoded = "";
			 
			
			 // Create a MessageDigest instance for SHA-1
		     MessageDigest digest = MessageDigest.getInstance(SHA);
		     
		     // Compute the hash value of the input string
		     byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
		     
		     // Encode the hash value using Base64
		     encoded = getBase64EncodeToString(hashBytes);
		      
		     // Print the encoded hash value
		     System.out.println("Encoded string: " + encoded);
		     
		     return encoded ;
		}

		public static String calculateSignature(String message) throws NoSuchAlgorithmException {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			
			// Compute the hash value of the input string
	        byte[] hashBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));
	        
	        // Encode the hash value using Base64
	        String encodedHash = getBase64EncodeToString(hashBytes);
			
			return encodedHash;
		}
		
		public static String signature(String message, String privateKeyData) 
				throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
	        String encodedMessage = null;

	        try {
	        	byte[] privateKeyBytes = privateKeyData.getBytes();
	            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
	            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
				
	            Cipher encryptCipher = Cipher.getInstance("RSA");
	            encryptCipher.init(Cipher.PRIVATE_KEY, privateKey);
	            byte[] secretMessageBytes = message.getBytes(StandardCharsets.UTF_8);
	            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
	            encodedMessage = getBase64EncodeToString(encryptedMessageBytes );
	        }catch (InvalidKeySpecException e) {
	        	logger.error(e.getMessage());
	            throw e;
				
	        } catch (RuntimeException e) {
	            logger.error(e.getMessage());
	            throw e;
	        } catch (NoSuchPaddingException e) {
	            logger.error(e.getMessage());
	            throw e;
	        } catch (NoSuchAlgorithmException e) {
	            logger.error(e.getMessage());
	            throw e;
	        } catch (InvalidKeyException e) {
	            logger.error(e.getMessage());
	            throw e;
	        } catch (IllegalBlockSizeException e) {
	            throw new RuntimeException(e);
	        } catch (BadPaddingException e) {
	            logger.error(e.getMessage());
	            throw e;
	        }
	        return encodedMessage;
	    }

		private static String getBase64EncodeToString(byte[] encryptedMessageBytes) {
			return Base64.getEncoder().encodeToString(encryptedMessageBytes);
		}
		
		
		
		
}
