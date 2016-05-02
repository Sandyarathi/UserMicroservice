package com.ps.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postshare/user")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(service.createUser(user),
				HttpStatus.CREATED);
	}

}
