package com.casino.provide.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.casino.provide.utility.SignatureUseful;
 

class ProvaderGameServiceImplTest {

	@InjectMocks
	public ProvaderGameService service;
	
    private String secretKey ;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new ProvaderGameServiceImpl();
		secretKey = buildPrivateKey();
	}

	

	@Test
	void test_generateSignature() {
		 
		try {
			String expectedOutput = "KNX2rAWC... 7NazNw==";
			
			String input = "1234-ABCD-5678"+"|"+"superspins";
			String signature = SignatureUseful.generateSignature(input, secretKey);
			System.out.println("signature : ");
			System.out.println(signature);
			 
		    String computedOutput = SignatureUseful.encodeToBase64(signature);
		    System.out.println("**********************");
			System.out.println("computedOutput : ");
			System.out.println(computedOutput);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

	
	private String buildPrivateKey() {
		String key = "MIIEogIBAAKCAQEA44L+QkfHcKqAUrWQ6HzxuFDQ3wUWKEUoES9iGCY4dKDw6esZP0uOPWXtUP+vO1U/wKYDTMaoJ/xa4jE3lcaA1kPiaSbgbE7Nxtt9ZEnBgzwapXzF+YjYAazZcSN87KreoQAQPdaps5mJzyQjSWRwht0tswYuUIN8UT21ujM9ikavf5A+Wp53rYOMTtC2Rx+7TmgKn6kZu8WjrFy/meiNYaTXd/9ytqrBYZZKF/odaBKP9E6SUYVSboySXuZHc7Ppz3uH5OQYJDYL7YDeOAynV0BhMKdHlhSc0rZVQ89iS1hoc4BGu2RHUv1u+ZU2yKX0PQNhlDtjIW0S5f4UboIhtwIDAQABAoIBAD6Eq4vZH6QFJlgUDqrkUqQciRkP08PjJRx70c/jCNZ7t1gAQ6LSB1c14B3G9Qcv6OHufK+nU2QRg4PulGCy+Ipogxn0Fe2NRhykCfP6FJQUexoIjHqCsSDct6/QWa7LUXwagVwM1ftFcMocGxo64HUe6ETuqOF1ED9e3sY4+Gs7drGbMlnp70cEjIu1ChIJKciMRQ/xwz60XTZKvNWCuibqZmjDKifO3Kmkp3bv7snhkmgY1o8nUIhTRhxdrYYjEZ4SkPk7d6LQXWUzyD950YhravPYd5tB6QX4GvSrK0p0F0Weg2zQDdsFoRaAzhAYsICzO4qvRMaamsOjJNo8a0ECgYEA8WNI0B165QfW56fmhEHUSWLSgEB3yx4Zuodqg05g1SMamxzJvCT70LIGR6Mrsc5qmzH/vV/6eDoHl0N4qJAYKEKN8cA9inBZBbxUc3BAp+aTBOrPZqlqHwMdg9+vllAVXSyyY58f6l19cUPZHhLxUwltEDBkRxFRsPzMRF3/HJcCgYEA8UispJFCi3vBqMjzoywDa2nxCNc2m0zAHJC2NAv3ZgAvRMTyqWC56/kxPGOAOhPQzmWqIExHfcw9eQBWUtrmfQgZdCS6yJPdeeF+yYyIedQyqhxtvfzV3zqT/GF+HVqrFp/WKONFlyBLdvLgH7DY+B8UGqJyQtRQEpnyVdZpJ+ECgYAP6z5IC0mphQTVLitzmWvIky3Sq227BXco5/lMQ4T7SV9dz142fDHnJ3Zmjwo4paY+KeP1tziraRhLD3YLl8UgEpON1+G3GYWlbTAclNCOwhP8BQg8evu2o9v0cHIB9bIS/PmevEW8jQHS0GinJRSpJzv8D1TtouTCSUmnUJOcbQKBgH6n6YhRgB78DcJuCgajegAOkqpTXqTS+x2DkUFs7qcqfaWZxM/IqJAINSJAEPVrpXZSw6VEpVqRtcsotCe2JLuJXuMqzKmxhNcP2aAvFwzsqNPHLIxIhnQxqbEX9D2wdJLhwGeiNcuI9lQwVhoMmThWCBWbJGOUU5wQF7ebX4PBAoGAKcsWHH61RHoXRx1xupVykqSfp2NKnbVfxVhUhKXxggPgqXVKwxWuYByFKDbm1Pz7EPRmCbuG0wDzgue3taZxQ/JoyINfZRzZg6duN5gV0wyRAa4eXf9AnnP6Y9O9i1vjDmNIiQ3djhOBhtqQjJ/gMszg9BVCeofR3kVx+K3KtZM=";
		return key;
	}
}
