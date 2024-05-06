package com.group5.dto;

public class BookMovies {
	
	private String userName;
	private String movieName; 
	private String noOfTickets;
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
	public String getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(String noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	@Override
	public String toString() {
		return "BookMovies [userName=" + userName + ", movieName=" + movieName + ", noOfTickets=" + noOfTickets + "]";
	}
	public BookMovies(String userName, String movieName, String noOfTickets) {
		super();
		this.userName = userName;
		this.movieName = movieName;
		this.noOfTickets = noOfTickets;
	}

	
	
	
}
