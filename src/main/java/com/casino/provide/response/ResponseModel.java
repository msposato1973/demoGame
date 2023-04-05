package com.casino.provide.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_NULL)
public class ResponseModel implements Serializable{
 
    private String gameId;
    private String token;
   
    public ResponseModel() {
        super();
    }
    public ResponseModel(String gameId, String token) {
        this.gameId = gameId;
        this.token = token;
    }
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

     
}
