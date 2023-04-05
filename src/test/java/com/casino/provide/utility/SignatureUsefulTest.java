package com.casino.provide.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SignatureUsefulTest {
    
	 
	
	@Test
	void testGenerateSignature() {
		String input = null;
		String privateKey = null;
		String expectedOutput=null;
		String computedOutput = null;
		
		try {
			computedOutput = 
			SignatureUseful.generateSignature(null, null);
			
		} catch (RuntimeException e) {
			 fail(e.getMessage());
			 
		}
	}

}
