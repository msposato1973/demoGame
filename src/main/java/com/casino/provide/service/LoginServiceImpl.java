package com.casino.provide.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casino.provide.model.User;
import com.casino.provide.repository.UserRepository;
import com.casino.provide.request.LoginRequest;
import com.casino.provide.response.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	// "66d488ba-cf4a-11ed-afa1-0242ac120002"
	@Override
	public Collection<User> findByUUID(String uuid) {
		Collection<User> listUser = userRepository.findByUUID(uuid);
		return listUser;
	}

	@Override
	public String retrieveUUID(LoginRequest request) {
		// TODO Auto-generated method stub
		
		User user = dtoToEntity(request);
		
		List<User> listUser = userRepository.findByUUIDByUserEndPassword(
													user.getUsername(), 
													user.getPassword()
									);
		logger.info("listUser.size() :" + listUser.size());
		 
		return listUser.get(0).getUUID();
	}

	private User dtoToEntity(LoginRequest request) {
		logger.info("dtoToEntity");

		return new User(request.getUser(), request.getPassword());
	}

	private LoginRequest entityToDTO(User entity) {

		return null;
	}

	@Override
	public UserDTO getUUID1(LoginRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
