package com.sattaporn.identity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sattaporn.dto.Login;
import com.sattaporn.model.User;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Override
	public final TokenUser loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException {
		System.out.println("Find User!");
		final User user = checkUser(username);
		TokenUser currentUser;
		if (user.isActive() == true) {
			currentUser = new TokenUser(user);
		} else {
			throw new DisabledException("User is not activated (Disabled User)");
			// If pending activation return a disabled user
			// currentUser = new TokenUser(user, false);
		}
		detailsChecker.check(currentUser);
		return currentUser;
	}

	private User checkUser(String username) {
		User user = null;

		if (username.equals("pondings")) {
			user = new User();
			user.setName("Pawarut");
			user.setLname("Klai-armon");
			user.setEmail("pawarut.klaiarmon@gmail.com");
			user.setBlocked(false);
			user.setActive(true);
			user.setId("1");
			user.setPassword("papapapond");
		}

		return user;

	}
}
