package com.group5.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group5.dto.Session;
import com.group5.filter.JwtUtil;
import com.group5.dto.BookMovies;
import com.group5.dto.GetMoviesRequest;
import com.group5.dto.Movies;
import com.group5.dto.MoviesUserReq;
import com.group5.repo.SessionRepository;
import com.group5.repo.UserMoviesRepository;
import com.group5.repo.MoviesRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class MoviesService {
	
	@Autowired
    private MoviesRepository moviesRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	UserMoviesRepository userMoviesRepository;


    public List<Movies> listMoviesForDate(GetMoviesRequest reqObj) {
    	List<Movies> moviesList = moviesRepository.findByDate(reqObj.getDate());
    	return moviesList;
    }


	public String addMovie(Movies reqObj) {
		moviesRepository.save(reqObj);
		return "successfully Added Movie for the date: "+reqObj.getDate();
	}


	public String bookMovie(BookMovies reqObj) {

			MoviesUserReq userMoviesRepositoryObj = new MoviesUserReq(reqObj.getUserName(),reqObj.getMovieName());
			userMoviesRepository.save(userMoviesRepositoryObj);
			Movies moviesObj = moviesRepository.findByTitle(reqObj.getMovieName());
			String existingNoOfSeats = moviesObj.getSeats();
			
			String[] existingSeatsArray = existingNoOfSeats.split(",");
		    String[] usedSeatsArray = reqObj.getNoOfTickets().split(",");
		    
		    if (existingSeatsArray.length != usedSeatsArray.length) {
		        throw new IllegalArgumentException("Existing and used seat strings must have the same number of sections.");
		      }
		    
		    int[] remainingSeats = new int[existingSeatsArray.length];
		    for (int i = 0; i < existingSeatsArray.length; i++) {
		      try {
		        int existingSeat = Integer.parseInt(existingSeatsArray[i]);
		        int usedSeat = Integer.parseInt(usedSeatsArray[i]);
		        remainingSeats[i] = Math.max(0, existingSeat - usedSeat); 
		      } catch (NumberFormatException e) {
		          throw new IllegalArgumentException("Invalid input: String contains non-numeric values.", e);
		      }
		    }
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < remainingSeats.length; i++) {
		      sb.append(remainingSeats[i]);
		      if (i < remainingSeats.length - 1) {
		        sb.append(",");
		      }
		    }
		    String remainingSeatsString = sb.toString();
			moviesObj.setSeats(remainingSeatsString);
			moviesRepository.save(moviesObj);
		return "Success";
	}


	public List<String> retrieveBooking(BookMovies reqObj) {
		List<MoviesUserReq> lstObj = userMoviesRepository.findByUserName(reqObj.getUserName());
		List<String> movieName = new ArrayList<String>();
		
		for(MoviesUserReq movieReqObj : lstObj) {
			if(!movieName.contains(movieReqObj.getMovieName()))
				movieName.add(movieReqObj.getMovieName());
		}
		
		return movieName;
	}

  


}
