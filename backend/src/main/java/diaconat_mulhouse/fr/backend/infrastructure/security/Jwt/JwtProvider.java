package diaconat_mulhouse.fr.backend.infrastructure.security.Jwt;

import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.AuthToken;
import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.TokenUserData;
import diaconat_mulhouse.fr.backend.infrastructure.security.Jwt.exceptions.ExpiredJwtException;
import diaconat_mulhouse.fr.backend.infrastructure.security.Jwt.exceptions.InvalidJwtException;
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
     * @param tokenUserData The user's prices of information for the token generation
     * @return The JWT
     */
    public AuthToken generateToken(TokenUserData tokenUserData) {
        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expirationDate = new Date(now + expirationTime);

        String token = Jwts.builder()
            .claim("userId", tokenUserData.id())
            .claim("roleId", tokenUserData.roleId())
            .setIssuedAt(issuedAt)
            .setExpiration(expirationDate)
            .signWith(secretKey)
            .compact();
        return new AuthToken(token);
    }

    /**
     * Public method that extract the email of a JWT token
     *
     * @param token The token
     * @return The user's pieces of information
     */
    public TokenUserData extract(String  token) throws ExpiredJwtException, InvalidJwtException {
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

            Long userId = claims.get("userId", Long.class);
            Long roleId = claims.get("roleId", Long.class);
            return TokenUserData.builder()
                    .id(userId)
                    .roleId(roleId)
                    .build();

        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw new ExpiredJwtException("Token expired");
        } catch (io.jsonwebtoken.JwtException e) {
            throw new InvalidJwtException("Invalid JWT token");
        }
    }
}
