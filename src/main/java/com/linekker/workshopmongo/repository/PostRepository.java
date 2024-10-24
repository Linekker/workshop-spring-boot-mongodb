package com.linekker.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.linekker.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
