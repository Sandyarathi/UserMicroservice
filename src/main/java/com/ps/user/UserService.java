package com.ps.user;

import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	private Integer generateID() {
		Random r = new Random();
		return r.nextInt(9000) + 1000;
	}

	public User createUser(User userobj) {
		User user = new User();
		Integer id = generateID();
		while (userRepo.exists(id))
			id = generateID();
		user.id = id;
		user.name = userobj.name;
		DateTime dt = new DateTime(DateTimeZone.UTC);

		user.created_at = dt.toString(ISODateTimeFormat.dateTime()
				.withZoneUTC());
		user.password = userobj.password;
		user.email = userobj.email;
		user.categoryChoices = userobj.categoryChoices;
		if (userRepo == null) {
			System.out.println("object is null here");
		}
		userRepo.save(user);
		return user;

	}

	public boolean validateModId(int userId) {
		if (!(userRepo.exists(userId)))
			return false;
		return true;
	}
}
