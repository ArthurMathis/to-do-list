package diaconat_mulhouse.fr.backend.core.security.Jwt;

import diaconat_mulhouse.fr.backend.core.security.Jwt.exceptions.ExpiredJwtException;
import diaconat_mulhouse.fr.backend.core.security.Jwt.exceptions.InvalidJwtException;
import diaconat_mulhouse.fr.backend.presentation.advices.apiResponse.ApiError;
import diaconat_mulhouse.fr.backend.presentation.advices.apiResponse.ApiResponseUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Class that filters API requests based on their authentication token
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain
    ) throws ServletException, IOException {
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        final String token = authorizationHeader.substring(7);
        try {
            final String email = jwtProvider.extract(token);
            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(email, null, null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch(ExpiredJwtException | InvalidJwtException jwtException) {
            ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, jwtException.getMessage(), httpServletRequest.getRequestURI());
            ApiResponseUtils.jsonError(httpServletResponse, apiError);
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
