package com.casino.provide.request;

public class Params {
	 
		private String token ; 
		private String gameid;
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getGameid() {
			return gameid;
		}
		public void setGameid(String gameid) {
			this.gameid = gameid;
		}
		public Params(RequestGameLaunch requestGameLaunch) {
			super();
			this.token = requestGameLaunch.getToken();
			this.gameid = requestGameLaunch.getGameid();
		}
		
		
}
