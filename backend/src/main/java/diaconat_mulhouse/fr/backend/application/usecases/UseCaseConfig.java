package diaconat_mulhouse.fr.backend.application.usecases;

import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.authenticate.AuthenticateUserUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments.IndexEstablishmentsByUserIdUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.user.indexEstablishments.IndexEstablishmentsByUserIdUseCaseImpl;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.authenticate.AuthenticateUserGateway;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.indexEstablishments.IndexEstablishmentsByUserIdGateway;
import diaconat_mulhouse.fr.backend.infrastructure.security.Jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCaseConfig {

    // * USERS * //
    @Bean
    public AuthenticateUserUseCase authenticateUserUseCase(AuthenticateUserGateway authenticateUserGateway, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        return new AuthenticateUserUseCaseImpl(authenticateUserGateway, passwordEncoder, jwtProvider);
    }

    @Bean
    public IndexEstablishmentsByUserIdUseCase indexEstablishmentsByUserIdUseCase(IndexEstablishmentsByUserIdGateway indexEstablishmentsByUserIdGateway) {
        return new IndexEstablishmentsByUserIdUseCaseImpl(indexEstablishmentsByUserIdGateway);
    }

}
