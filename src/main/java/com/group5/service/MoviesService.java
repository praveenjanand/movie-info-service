package com.group5.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group5.dto.Session;
import com.group5.filter.JwtUtil;
import com.group5.dto.GetMoviesRequest;
import com.group5.dto.Movies;
import com.group5.repo.SessionRepository;
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


    public List<Movies> listMoviesForDate(GetMoviesRequest reqObj) {
    	List<Movies> moviesList = moviesRepository.findByDate(reqObj.getDate());
    	return moviesList;
    }


	public String addMovie(Movies reqObj) {
		moviesRepository.save(reqObj);
		return "successfully Added Movie for the date: "+reqObj.getDate();
	}

  


}
