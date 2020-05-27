package com.github.linsfilipe.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import static io.jsonwebtoken.Jwts.builder;
import static io.jsonwebtoken.Jwts.parser;
import static io.jsonwebtoken.SignatureAlgorithm.HS512;

public final class JWTUtil {

    private final static String SECRET_TOKEN = "cddc1c03fe76169da35bc478c7187dec";
    public final static String HEADER_AUTHORIZATION = "Authorization";

    public static String encode(final String subject) {
        return builder()
                .setSubject(subject)
                .signWith(HS512, SECRET_TOKEN)
                .compact();

    }

    public static Jws<Claims> decode(final String token) {
    	final String tokenOnly = removeBearer(token);
        return parser()
                .setSigningKey(SECRET_TOKEN)
                .parseClaimsJws(tokenOnly);
    }

	public static String removeBearer(final String token) {
		return token.replace("Bearer ", "");
	}

}
