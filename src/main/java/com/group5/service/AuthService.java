package com.group5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.group5.dto.GetMoviesRequest;

@Service
public class AuthService {
	
	@Autowired
    private RestTemplate restTemplate;

    public Boolean validateToken(String userName, String token) {
    	
    	GetMoviesRequest request = new GetMoviesRequest();
    	 request.setToken(token);
         request.setUserName(userName);
         System.out.println("Inside validateToken username" +userName);
         boolean returnFlag = true;
         HttpHeaders headers = new HttpHeaders();
         headers.add("Content-Type", "application/json");
    	try {
        HttpEntity<GetMoviesRequest> requestEntity = new HttpEntity<>(request, headers);
    	
            ResponseEntity<Boolean> response = restTemplate.postForEntity(
                    "http://localhost:8080/api/v1/users/validateToken",
                    requestEntity,
                    Boolean.class
        );
    	}catch(Exception e) {
    		//returnFlag = false;
    		e.printStackTrace();
    	}
       return returnFlag;
    }

}
