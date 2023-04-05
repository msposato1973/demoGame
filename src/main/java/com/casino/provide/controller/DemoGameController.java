package com.casino.provide.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casino.provide.config.IWebParams;
import com.casino.provide.request.LoginRequest;
import com.casino.provide.request.RequestGameLaunch;
import com.casino.provide.request.RequestSimulatedGameProvide;
import com.casino.provide.service.LoginServiceImpl;
import com.casino.provide.service.ProvaderGameService;


@CrossOrigin
@RestController
@RequestMapping(IWebParams.API)
public class DemoGameController extends  AbstractController {
	 
	private static final Logger logger = LoggerFactory.getLogger(DemoGameController.class);
	
	@Value("${sbpg.init.secretKey}")
	private String secretKey;
	
	@Value("${sbpg.init.gamelaunchUrl}")
	private String gamelaunchUrl;
	
	public DemoGameController(final LoginServiceImpl loginService, final ProvaderGameService provaderGameService) {
		this.loginService = loginService;
		this.provaderGameService = provaderGameService;
	}
	
	@RequestMapping(
			value = IWebParams.API_LOGIN, 
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
    public String login( @RequestBody LoginRequest loginRequest) throws Exception {
		logger.debug("START -login");

        return executeLogin(loginRequest);
    }
	
	@RequestMapping(
			value = IWebParams.API_LUNCH, 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE
	)
    public String lunchGaming(@RequestBody  RequestGameLaunch request ) throws Exception {
		logger.debug("START -lunchGaming");
        return  executeLunchGaming(request);
    }

	/***
	 * 
	 * @param request
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws NoSuchAlgorithmException
	 */
    private String executeLunchGaming(final RequestGameLaunch request) throws URISyntaxException, IOException, InterruptedException, InvalidKeyException, SignatureException, NoSuchAlgorithmException {
    	logger.debug("START -executeLunchGaming");
    	logger.info("- executeLunchGaming Token : " + request.getToken());
    	logger.info("- executeLunchGaming Gameid : " + request.getGameid());
    	String message = request.getToken() + "|" + request.getGameid();
    	logger.info("START executeLunchGaming - message : " + message);
    	
    	logger.debug("START executeLunchGaming - signature : " );
    	String signature = provaderGameService.generateSignature(message, secretKey);
    			//provaderGameService.generateSignature(message);
    	// provaderGameService.getSignatureWithKey(message);
    	// provaderGameService.getSignature(message);
    	// provaderGameService.calculateSignature(message);
    	// provaderGameService.generateSignature(message);
    	logger.info("END executeLunchGaming - signature ( token|gameid ) : " + signature);
    	
    	RequestSimulatedGameProvide requestSimulatedGameProvide = createRequestGameProvide(signature, request);
    	logger.debug(" requestSimulatedGameProvide -  : " + requestSimulatedGameProvide);
    	
    	logger.debug("START executeLunchGaming - provaderGameService.gamelaunchProvider : " );
    	String jsonResponse = provaderGameService.gamelaunchProvider(requestSimulatedGameProvide);
    	logger.debug("START executeLunchGaming - provaderGameService.gamelaunchProvider : " + jsonResponse );
    	
		return jsonResponse;
	}

    /***
     * 
     * @param loginRequest
     * @return
     */
	private String executeLogin(final LoginRequest loginRequest) {
		logger.debug("START -executeLogin");
		 
 		return loginService.retrieveUUID(loginRequest);
	}
	
	 
}
