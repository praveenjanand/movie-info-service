package com.group5.dto;

public class AddMoviesRequest {
	
	private String movieId;
    private String movieName;
    private String date;
    private String totalCount;
    private String availableCount;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(String availableCount) {
		this.availableCount = availableCount;
	}

	
    

}
