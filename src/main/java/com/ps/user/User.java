package com.ps.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Null
	@Id
	public Integer id;
	@NotNull
	public String name;
	@NotNull
	public String email;
	@NotNull
	public String password;
	@Null
	public String created_at;
	@NotNull
	public String[] categoryChoices;

	@Override
	public String toString() {
		return String.format("User[id=%d, name=%s, email=%s]", id, name, email);
	}

	public User(User user) {
		this.id = user.id;
		this.created_at = user.created_at;
		this.email = user.email;
		this.name = user.name;
		this.password = user.password;

	}

	public User() {
		// TODO Auto-generated constructor stub
	}

}