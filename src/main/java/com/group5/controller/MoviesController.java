package com.group5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group5.dto.AddMoviesRequest;
import com.group5.dto.BookMovies;
import com.group5.dto.GetMoviesRequest;
import com.group5.dto.Movies;
import com.group5.service.AuthService;
import com.group5.service.MoviesService;

@RestController
@RequestMapping("/api/v1/movie-info")
public class MoviesController {
	
	 @Autowired
	 private MoviesService moviesService;
	 
    @Autowired
    private AuthService authService;

    	@CrossOrigin(origins = "*")
    	@PostMapping("/findMoviesByDate")
	    public ResponseEntity<List<Movies>> findMoviesByDate(@RequestBody GetMoviesRequest reqObj, @RequestHeader("Authorization") String authorizationHeader) {
	       
	    	String token = extractToken(authorizationHeader);
	        
	        Boolean validationResult = authService.validateToken(reqObj.getUserName(),token);
	        if (validationResult) {
	    	
	    	List<Movies> moviesList = moviesService.listMoviesForDate(reqObj);
	        return ResponseEntity.ok(moviesList);
	        }else {
	            throw new IllegalArgumentException("Bearer token Invalid");
	        }
	    }

	    @CrossOrigin(origins = "*")
	    @PostMapping("/addMovie")
	    public ResponseEntity<String> addMovie(@RequestBody Movies reqObj) {
	        String moviesList = moviesService.addMovie(reqObj);
	        return ResponseEntity.ok(moviesList);
	    }
	    
	    private String extractToken(String authorizationHeader) {
	        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            return authorizationHeader.substring(7);
	        } else {
	            throw new IllegalArgumentException("Bearer token not found in Authorization header");
	        }
	    }
	    
	    @PostMapping("/bookMovie")
	    public ResponseEntity<String> bookMovie(@RequestBody BookMovies reqObj) {
	        String moviesList = moviesService.bookMovie(reqObj);
	        return ResponseEntity.ok(moviesList);
	    }

	    @PostMapping("/retrieveBooking")
	    public ResponseEntity<List<String>> retrieveBooking(@RequestBody BookMovies reqObj) {
	    	List<String> moviesList = moviesService.retrieveBooking(reqObj);
	        return ResponseEntity.ok(moviesList);
	    }
}
