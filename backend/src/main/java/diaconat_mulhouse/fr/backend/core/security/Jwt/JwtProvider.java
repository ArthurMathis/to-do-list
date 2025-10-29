package diaconat_mulhouse.fr.backend.core.security.Jwt;

import diaconat_mulhouse.fr.backend.application.DTOs.user.AuthToken;
import diaconat_mulhouse.fr.backend.core.security.Jwt.exceptions.ExpiredJwtException;
import diaconat_mulhouse.fr.backend.core.security.Jwt.exceptions.InvalidJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * class that generates new JWT
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Component
public class JwtProvider {

    private final SecretKey secretKey;
    private final long expirationTime;

    public JwtProvider(
            @Value("${security.jwt.secret-key}") String secretKey,
            @Value("${security.jwt.expiration-time}") long expirationTime
    ) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        this.secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
        this.expirationTime = expirationTime;
    }

    /**
     * Public method that generates a JWT
     *
     * @param email The user's email
     * @return The JWT
     */
    public AuthToken generateToken(String email) {
        String token = Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(secretKey)
            .compact();
        return new AuthToken(token);
    }

    /**
     * Public method that extract the email of a JWT token
     *
     * @param token The token
     * @return The email
     */
    public String extract(String  token) throws ExpiredJwtException, InvalidJwtException {
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

            return claims.getSubject();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw new ExpiredJwtException("Token expired");
        } catch (io.jsonwebtoken.JwtException e) {
            throw new InvalidJwtException("Invalid JWT token");
        }
    }
}
