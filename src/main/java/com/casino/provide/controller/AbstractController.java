package com.casino.provide.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.casino.provide.model.User;
import com.casino.provide.request.RequestGameLaunch;
import com.casino.provide.request.RequestSimulatedGameProvide;
import com.casino.provide.response.UserDTO;
import com.casino.provide.service.LoginService;
import com.casino.provide.service.ProvaderGameService;
import com.casino.provide.request.*;

/***
 * 
 * @author maxp7
 *
 */
public abstract class AbstractController {

	@Autowired
	protected  LoginService loginService;
	
	@Autowired
	protected  ProvaderGameService provaderGameService;
	
	/***
	 * 
	 * @param user
	 * @return
	 */
	protected UserDTO getEntityToDTOResponse(User user) {
		return new UserDTO(user.getId(), user.getUsername(), user.getPassword(),user.getUUID());
	}
	
	/***
	 * 
	 * @param signature
	 * @param requestGameLaunch
	 * @return
	 */
    protected RequestSimulatedGameProvide  createRequestGameProvide(String signature, RequestGameLaunch requestGameLaunch ) {
		return new RequestSimulatedGameProvide(signature, new Params(requestGameLaunch));
	}
}
