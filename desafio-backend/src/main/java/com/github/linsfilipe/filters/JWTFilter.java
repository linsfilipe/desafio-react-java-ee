package com.github.linsfilipe.filters;

import static com.github.linsfilipe.utils.JWTUtil.HEADER_AUTHORIZATION;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.linsfilipe.utils.JWTUtil;

import io.jsonwebtoken.SignatureException;

@WebFilter(asyncSupported = true, urlPatterns = { "/api/*" })
public class JWTFilter extends HttpFilter {

	private static final long serialVersionUID = 1267812686901287657L;
	private final static String LOGIN = "auth";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        if (httpServletRequest.getRequestURI().contains(LOGIN)) {
            chain.doFilter(req, res);
            return;
        }

        final String token = extractToken(httpServletRequest);

        if (token == null || token.isEmpty()) {
            httpServletResponse.setStatus(SC_UNAUTHORIZED);
            return;
        }

        decodeToken(req, res, chain, httpServletResponse, token);
    }

    private void decodeToken(final ServletRequest req,
                             final ServletResponse res,
                             final FilterChain chain,
                             final HttpServletResponse httpServletResponse,
                             final String token) throws IOException, ServletException {
        try {
            JWTUtil.decode(token);
            chain.doFilter(req, res);
        } catch (SignatureException e) {
            httpServletResponse.setStatus(SC_UNAUTHORIZED);
        }
    }


    private String extractToken(final HttpServletRequest request) {
        return request.getHeader(HEADER_AUTHORIZATION);
    }
}
