package com.group5.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.group5.dto.MoviesUserReq;


@Component
@Repository
public interface UserMoviesRepository extends MongoRepository<MoviesUserReq, String> {

	List<MoviesUserReq> findByUserName(String userName);


}
