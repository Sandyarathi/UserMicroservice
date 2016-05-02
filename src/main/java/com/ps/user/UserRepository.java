package com.ps.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

//@Repository
//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Service
public interface UserRepository extends MongoRepository<User, Integer> {

	public User findById(Integer id);
	// public User save(User saveUser);

}