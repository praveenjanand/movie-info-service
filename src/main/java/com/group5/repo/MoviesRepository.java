package com.group5.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.group5.dto.*;

@Component
@Repository
public interface MoviesRepository extends MongoRepository<Movies, String> {
	List<Movies> findByDate(String date);

}
