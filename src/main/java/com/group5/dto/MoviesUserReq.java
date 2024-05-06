package com.group5.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("User_X_Movies")
public class MoviesUserReq {
	
	private String userName;
	private String movieName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public MoviesUserReq(String userName, String movieName) {
		super();
		this.userName = userName;
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "MoviesUserReq [userName=" + userName + ", movieName=" + movieName + "]";
	}
	
	

}
