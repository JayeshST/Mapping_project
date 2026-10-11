package com.app.Filter;

import com.app.repository.TokenRepository;
import com.fasterxml.classmate.Filter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class TokenFilter implements Filter {

    private final TokenRepository tokenRepository;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        String token = httpReq.getHeader("X-CSRF-Token");

        if (httpReq.getRequestURI().contains("/auth/login")) {
            chain.doFilter(request, response);
            return;
        }

        if (token == null || tokenRepository.findByToken(token).isEmpty()) {
            HttpServletResponse httpRes = (HttpServletResponse) response;
            httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpRes.getWriter().write("Invalid or missing CSRF token");
            return;
        }

        chain.doFilter(request, response);
    }

	@Override
	public boolean include(Object element) {
		// TODO Auto-generated method stub
		return false;
	}
}
