package diaconat_mulhouse.fr.backend.infrastructure.gateways;

import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.project.jpa.ProjectJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverter;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get.GetEstablishmentGateway;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get.GetEstablishmentGatewayImpl;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.indexProjects.IndexProjectsByEstablishmentIdGateway;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.indexProjects.IndexProjectsByEstablishmentIdGatewayImpl;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.authenticate.AuthenticateUserGateway;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.authenticate.AuthenticateUserGatewayImpl;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.indexEstablishments.IndexEstablishmentsByUserIdGateway;
import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.indexEstablishments.IndexEstablishmentsByUserIdGatewayImpl;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    // *  USERS * //
    @Bean
    public IndexEstablishmentsByUserIdGateway indexEstablishmentByUserIdGateway(UserRepository userRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        return new IndexEstablishmentsByUserIdGatewayImpl(userRepository, establishmentJPAConverter);
    }

    @Bean
    public AuthenticateUserGateway authenticateUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new AuthenticateUserGatewayImpl(userRepository, userJPAConverter);
    }

    // * ESTABLISHMENT * //
    @Bean
    public GetEstablishmentGateway getEstablishmentGateway(EstablishmentRepository establishmentrepository, EstablishmentJPAConverter establishmentJPAConverter) {
        return new GetEstablishmentGatewayImpl(establishmentrepository, establishmentJPAConverter);
    }

    @Bean
    public IndexProjectsByEstablishmentIdGateway indexProjectsByEstablishmentIdGateway(EstablishmentRepository establishmentRepository, ProjectJPAConverter projectJPAConverter) {
        return new IndexProjectsByEstablishmentIdGatewayImpl(establishmentRepository, projectJPAConverter);
    }

}
