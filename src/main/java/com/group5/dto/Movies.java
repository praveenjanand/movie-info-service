package com.group5.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Movies")
public class Movies {
    @Id
    private String id;
    private String title;
    private String date;
    private String seats;
    private String showtimes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(String showtimes) {
		this.showtimes = showtimes;
	}
	public Movies(String title, String date, String seats, String showtimes) {
		super();
		this.title = title;
		this.date = date;
		this.seats = seats;
		this.showtimes = showtimes;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", date=" + date + ", seats=" + seats + ", showtimes="
				+ showtimes + "]";
	}
    
	
    

}