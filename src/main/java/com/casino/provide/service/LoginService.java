package com.casino.provide.service;
 

import java.util.Collection;

import com.casino.provide.model.User;
import com.casino.provide.request.LoginRequest;
import com.casino.provide.response.UserDTO;

/***
 * 
 * @author maxp7
 *
 */
public interface LoginService {

	  
	 /***
	  * 
	  * @param request
	  * @return
	  */
	 UserDTO getUUID1(LoginRequest request);
	 
	 /***
	  * 
	  * @param request
	  * @return
	  */
	 String retrieveUUID(LoginRequest request);
	 
	 /***
	  * 
	  * @param uuid
	  * @return
	  */
	 Collection<User> findByUUID(String uuid);
	 
	  
}
