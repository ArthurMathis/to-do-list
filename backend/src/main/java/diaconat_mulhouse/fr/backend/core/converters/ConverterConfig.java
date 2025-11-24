package diaconat_mulhouse.fr.backend.core.converters;

import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.core.converters.establishment.createEstablishment.CreateEstablishmentConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.createEstablishment.CreateEstablishmentConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJson.EstablishmentJsonConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.establishment.updateEstablishment.UpdateEstablishmentConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.updateEstablishment.UpdateEstablishmentConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.log.createLogConverter.CreateLogConverter;
import diaconat_mulhouse.fr.backend.core.converters.log.createLogConverter.CreateLogConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.log.logJPAConverter.LogJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.log.logJPAConverter.LogJPAConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.log.logJsonConverter.LogJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.log.logJsonConverter.LogJsonConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.log.updateLogConverter.UpdateLogConverter;
import diaconat_mulhouse.fr.backend.core.converters.log.updateLogConverter.UpdateLogConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.logType.createLogType.CreateLogTypeConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.createLogType.CreateLogTypeConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJPA.LogTypeJPAConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJson.LogTypeJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.logTypeJson.LogTypeJsonConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.logType.updateLogType.UpdateLogTypeConverter;
import diaconat_mulhouse.fr.backend.core.converters.logType.updateLogType.UpdateLogTypeConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.map.MapConverter;
import diaconat_mulhouse.fr.backend.core.converters.map.MapConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.user.createUser.CreateUserConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.createUser.CreateUserConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.user.updateUser.UpdateUserConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.updateUser.UpdateUserConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.userJPA.UserJPAConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.user.userJson.UserJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.user.userJson.UserJsonConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConverterConfig {

    // * MAP * //
    @Bean
    public MapConverter mapConverter() {
        return new MapConverterImpl();
    }

    // * LOG TYPE * //
    @Bean
    public LogTypeJPAConverter logTypeJPAConverter() {
        return new LogTypeJPAConverterImpl();
    }

    @Bean
    public LogTypeJsonConverter logTypeJsonConverter() {
        return new LogTypeJsonConverterImpl();
    }

    @Bean
    public CreateLogTypeConverter createLogTypeConverter() {
        return new CreateLogTypeConverterImpl();
    }

    @Bean
    public UpdateLogTypeConverter updateLogTypeConverter() {
        return new UpdateLogTypeConverterImpl();
    }

    // * LOG * //
    @Bean
    public LogJPAConverter logJPAConverter(LogTypeJPAConverter logTypeJPAConverter, UserJPAConverter userJPAConverter, MapConverter mapConverter) {
        return new LogJPAConverterImpl(logTypeJPAConverter, userJPAConverter, mapConverter);
    }

    @Bean
    public LogJsonConverter logJsonConverter(LogTypeJsonConverter logTypeJsonConverter, UserJsonConverter userJsonConverter) {
        return new LogJsonConverterImpl(logTypeJsonConverter, userJsonConverter);
    }

    @Bean
    public CreateLogConverter createLogConverter(LogTypeJsonConverter logTypeJsonConverter, UserJsonConverter userJsonConverter) {
        return new CreateLogConverterImpl(logTypeJsonConverter, userJsonConverter);
    }

    @Bean
    public UpdateLogConverter updateLogTypeConverter(LogTypeJsonConverter logTypeJsonConverter, UserJsonConverter userJsonConverter) {
        return new UpdateLogConverterImpl(logTypeJsonConverter, userJsonConverter);
    }

    // * ESTABLISHMENTS * //
    @Bean
    public EstablishmentJPAConverter establishmentJPAConverter() {
        return new EstablishmentJPAConverterImpl();
    }

    @Bean
    EstablishmentJsonConverter establishmentJsonConverter() {
        return new EstablishmentJsonConverterImpl();
    }

    @Bean
    public CreateEstablishmentConverter createEstablishmentConverter() {
        return new CreateEstablishmentConverterImpl();
    }

    @Bean
    public UpdateEstablishmentConverter updateEstablishmentConverter() {
        return new UpdateEstablishmentConverterImpl();
    }

    // * USERS * //
    @Bean
    public UserJPAConverter userJPAConverter(EstablishmentJPAConverter establishmentJPAConverter) {
        return new UserJPAConverterImpl(establishmentJPAConverter);
    }

    @Bean
    public UserJsonConverter userJsonConverter(EstablishmentService establishmentService, EstablishmentJsonConverter establishmentJsonConverter) {
        return new UserJsonConverterImpl(establishmentService, establishmentJsonConverter);
    }

    @Bean
    public CreateUserConverter createUserConverter(EstablishmentService establishmentService, EstablishmentJsonConverter establishmentJsonConverter, PasswordEncoder passwordEncoder) {
        return new CreateUserConverterImpl(establishmentService, establishmentJsonConverter, passwordEncoder);
    }

    @Bean
    public UpdateUserConverter updateUserConverter(EstablishmentService establishmentService, EstablishmentJsonConverter establishmentJsonConverter) {
        return new UpdateUserConverterImpl(establishmentService, establishmentJsonConverter);
    }

    // * TASKS * //

}
