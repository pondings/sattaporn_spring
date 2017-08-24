package com.sattaporn.Configuration;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.sattaporn.identity.TokenUtil;

import io.jsonwebtoken.JwtException;

public class VerifyTokenFilter extends GenericFilterBean {

	private final TokenUtil tokenUtil;

	public VerifyTokenFilter(TokenUtil tokenUtil) {
		this.tokenUtil = tokenUtil;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		try {
			Optional<Authentication> authentication = tokenUtil.verifyToken(request);
			if (authentication.isPresent()) {
				SecurityContextHolder.getContext().setAuthentication(authentication.get());
			} else {
				SecurityContextHolder.getContext().setAuthentication(null);
			}
			filterChain.doFilter(req, res);
		} catch (JwtException e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} finally {
			SecurityContextHolder.getContext().setAuthentication(null);
			return; // always return void
		}
	}
}
