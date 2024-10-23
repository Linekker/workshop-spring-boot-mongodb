package com.linekker.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linekker.workshopmongo.domain.User;
import com.linekker.workshopmongo.repository.UserRepository;
import com.linekker.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> FindAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		User user = repo.findById(id).orElse(null);

		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		
		return user;
	}
}
