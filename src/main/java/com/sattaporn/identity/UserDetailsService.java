package com.sattaporn.identity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sattaporn.dto.Login;
import com.sattaporn.model.Employee;
import com.sattaporn.model.User;
import com.sattaporn.repository.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Override
	public final TokenUser loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException {
		final User user = userRepository.findUserByUsername(username);
		TokenUser currentUser;
		if (user.getIsActive() == true) {
			currentUser = new TokenUser(user);
		} else {
			throw new DisabledException("User is not activated (Disabled User)");
		}
		detailsChecker.check(currentUser);
		return currentUser;
	}

}
