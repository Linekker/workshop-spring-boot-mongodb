package com.linekker.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linekker.workshopmongo.domain.Post;
import com.linekker.workshopmongo.repository.PostRepository;
import com.linekker.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findById(id).orElse(null);

		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}

		return user;
	}

	public List<Post> findByTitle (String Text){
	   return repo.searchTitle(Text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
