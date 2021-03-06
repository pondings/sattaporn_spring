package com.sattaporn.identity;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.sattaporn.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenUtil {

//	private static final long VALIDITY_TIME_MS = 2 * 60 * 60 * 1000; // 2 hours validity
	private static final long VALIDITY_TIME_MS = 30 * 60 * 1000; // 30 min validity
	private static final String AUTH_HEADER_NAME = "Authorization";

	private String secret = "8b2925a4fae063f338afc481cacc3351";

	public Optional<Authentication> verifyToken(HttpServletRequest request) {
		final String token = request.getHeader(AUTH_HEADER_NAME);

		if (token != null && !token.isEmpty()) {
			final TokenUser user = parseUserFromToken(token.replace("Bearer", "").trim());
			if (user != null) {
				return Optional.of(new UserAuthentication(user));
			}
		}
		return Optional.empty();

	}

	// Get User Info from the Token
	public TokenUser parseUserFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		String username = (String)claims.get("username");
		User user = new User();
		user.setUsername(username);
		return new TokenUser(user);
	}

	public String createTokenForUser(TokenUser tokenUser) {
		return createTokenForUser(tokenUser.getUser());
	}

	public String createTokenForUser(User user) {
		return Jwts.builder().setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME_MS))
				.setSubject(user.getEmployee().getName()).claim("username", user.getUsername())
				.claim("role", "USER").signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
