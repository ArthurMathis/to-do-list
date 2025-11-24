package diaconat_mulhouse.fr.backend.core.gateways;

import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.log.logJPAConverter.LogJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.create.CreateEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.create.CreateEstablishmentGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.delete.DeleteEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.delete.DeleteEstablishmentGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.get.GetEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.get.GetestablishmentGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.index.IndexEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.index.IndexEstablishmentGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.update.UpdateEstablishmentGateway;
import diaconat_mulhouse.fr.backend.core.gateways.establishment.update.UpdateEstablishmentGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.log.index.IndexLogGateway;
import diaconat_mulhouse.fr.backend.core.gateways.log.index.IndexLogGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.logType.create.CreateLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.create.CreateLogTypeGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.logType.delete.DeleteLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.delete.DeleteLogTypeGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.logType.get.GetLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.get.GetLogTypeGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.logType.index.IndexLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.index.IndexLogTypeGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.logType.update.UpdateLogTypeGateway;
import diaconat_mulhouse.fr.backend.core.gateways.logType.update.UpdateLogTypeGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.user.authenticate.AuthenticateUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.authenticate.AuthenticateUserGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.user.create.CreateUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.create.CreateUserGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.user.delete.DeleteUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.delete.DeleteUserGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.user.get.GetUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.get.GetUserGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.user.index.IndexUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.index.IndexUserGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.user.update.UpdateUserGateway;
import diaconat_mulhouse.fr.backend.core.gateways.user.update.UpdateUserGatewayImpl;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.LogRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    // * LOG TYPE * //
    @Bean
    public IndexLogTypeGateway indexLogTypeGateway(LogTypeRepository logTypeRepository, LogTypeJPAConverter logTypeJPAConverter) {
        return new IndexLogTypeGatewayImpl(logTypeRepository,  logTypeJPAConverter);
    }

    @Bean
    public GetLogTypeGateway getLogTypeGateway(LogTypeRepository logTypeRepository,  LogTypeJPAConverter logTypeJPAConverter) {
        return new GetLogTypeGatewayImpl(logTypeRepository,  logTypeJPAConverter);
    }

    @Bean
    public CreateLogTypeGateway createLogTypeGateway(LogTypeRepository logTypeRepository, LogTypeJPAConverter logTypeJPAConverter) {
        return new CreateLogTypeGatewayImpl(logTypeRepository,  logTypeJPAConverter);
    }

    @Bean
    public UpdateLogTypeGateway updateLogTypeGateway(LogTypeRepository logTypeRepository, LogTypeJPAConverter logTypeJPAConverter) {
        return new UpdateLogTypeGatewayImpl(logTypeRepository,  logTypeJPAConverter);
    }

    @Bean
    public DeleteLogTypeGateway deleteLogTypeGateway(LogTypeRepository logTypeRepository) {
        return new DeleteLogTypeGatewayImpl(logTypeRepository);
    }

    // * LOG * //
    @Bean
    public IndexLogGateway indexLogGateway(LogRepository logRepository, LogJPAConverter logJPAConverter) {
        return new IndexLogGatewayImpl(logRepository,  logJPAConverter);
    }

    // * ESTABLISHMENTS * //
    @Bean
    public IndexEstablishmentGateway indexEstablishmentGateway(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        return new IndexEstablishmentGatewayImpl(establishmentRepository, establishmentJPAConverter);
    }

    @Bean
    public GetEstablishmentGateway getEstablishmentGateway(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        return new GetestablishmentGatewayImpl(establishmentRepository, establishmentJPAConverter);
    }

    @Bean
    public CreateEstablishmentGateway createEstablishmentGateway(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        return new CreateEstablishmentGatewayImpl(establishmentRepository, establishmentJPAConverter);
    }

    @Bean
    public UpdateEstablishmentGateway updateEstablishmentGateway(EstablishmentRepository establishmentRepository, EstablishmentJPAConverter establishmentJPAConverter) {
        return new UpdateEstablishmentGatewayImpl(establishmentRepository, establishmentJPAConverter);
    }

    @Bean
    public DeleteEstablishmentGateway deleteEstablishmentGateway(EstablishmentRepository establishmentRepository) {
        return new DeleteEstablishmentGatewayImpl(establishmentRepository);
    }

    // *  USERS * //
    @Bean
    public IndexUserGateway indexUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new IndexUserGatewayImpl(userRepository, userJPAConverter);
    }

    @Bean
    public GetUserGateway getUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new GetUserGatewayImpl(userRepository, userJPAConverter);
    }

    @Bean
    public CreateUserGateway createUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new CreateUserGatewayImpl(userRepository, userJPAConverter);
    }

    @Bean
    public UpdateUserGateway updateUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new UpdateUserGatewayImpl(userRepository, userJPAConverter);
    }

    @Bean
    public DeleteUserGateway deleteUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new DeleteUserGatewayImpl(userRepository, userJPAConverter);
    }

    @Bean
    public AuthenticateUserGateway authenticateUserGateway(UserRepository userRepository, UserJPAConverter userJPAConverter) {
        return new AuthenticateUserGatewayImpl(userRepository, userJPAConverter);
    }

    // * TASKS * //
}
