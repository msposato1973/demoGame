package com.casino.provide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casino.provide.model.User;
 

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM users u WHERE u.uuid = :uuid", nativeQuery = true)
	public List<User> findByUUID(String uuid);

	@Query(value = "SELECT * FROM users u WHERE u.username = :username and u.password = :pswd", nativeQuery = true)
	public List<User> findByUUIDByUserEndPassword(String username,String pswd);

}
