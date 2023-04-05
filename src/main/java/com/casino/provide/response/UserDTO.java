package com.casino.provide.response;

import java.io.Serializable;
 

public class UserDTO implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String username;
    private String password;
    private String UUID ;
    
    public UserDTO() {
		super();
	}
    
	public UserDTO(Long id, String username, String password, String uUID) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		UUID = uUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	
}
