package com.fm.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fm.model.Blog;

@Repository
public interface BlogRepo extends MongoRepository<Blog, String> {

}
