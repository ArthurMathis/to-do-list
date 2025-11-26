package diaconat_mulhouse.fr.backend.application.converters;

import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.create.EstablishmentCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.jpa.EstablishmentJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.json.EstablishmentJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.establishment.update.EstablishmentUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.log.create.LogCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.log.create.LogCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.log.jpa.LogJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.log.jpa.LogJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.log.json.LogJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.log.json.LogJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.log.update.LogUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.log.update.LogUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.logType.create.LogTypeCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.create.LogTypeCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.logType.jpa.LogTypeJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.jpa.LogTypeJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.logType.json.LogTypeJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.json.LogTypeJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.logType.update.LogTypeUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.logType.update.LogTypeUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.map.MapConverter;
import diaconat_mulhouse.fr.backend.application.converters.map.MapConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.project.create.ProjectCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.project.create.ProjectCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.project.jpa.ProjectJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.project.jpa.ProjectJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.project.json.ProjectJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.project.json.ProjectJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.project.update.ProjectUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.project.update.ProjectUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.role.create.RoleCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.role.create.RoleCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.role.jpa.RoleJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.role.jpa.RoleJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.role.json.RoleJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.role.json.RoleJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.role.update.RoleUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.role.update.RoleUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.task.create.TaskCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.task.create.TaskCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.task.jpa.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.task.jpa.TaskJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.task.json.TaskJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.task.json.TaskJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.task.update.TaskUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.task.update.TaskUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.user.create.UserCreateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.create.UserCreateConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.jpa.UserJPAConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.user.json.UserJsonConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.json.UserJsonConverterImpl;
import diaconat_mulhouse.fr.backend.application.converters.user.update.UserUpdateConverter;
import diaconat_mulhouse.fr.backend.application.converters.user.update.UserUpdateConverterImpl;
import diaconat_mulhouse.fr.backend.domain.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    // * MAP * //
    @Bean
    public MapConverter mapConverter() {
        return new MapConverterImpl();
    }

    // * LOG TYPE * //
    @Bean
    public LogTypeJPAConverter logTypeJPAConverter(LogRepository logRepository) {
        return new LogTypeJPAConverterImpl(logRepository);
    }

    @Bean
    public LogTypeJsonConverter logTypeJsonConverter() {
        return new LogTypeJsonConverterImpl();
    }

    @Bean
    public LogTypeCreateConverter logTypeCreateConverter() {
        return new LogTypeCreateConverterImpl();
    }

    @Bean
    public LogTypeUpdateConverter logTypeUpdateConverter() {
        return new LogTypeUpdateConverterImpl();
    }

    // * LOG * //
    @Bean
    public LogJPAConverter logJPAConverter(LogTypeRepository logTypeRepository, UserRepository userRepository, MapConverter mapConverter) {
        return new LogJPAConverterImpl(logTypeRepository, userRepository, mapConverter);
    }

    @Bean
    public LogJsonConverter logJsonConverter() {
        return new LogJsonConverterImpl();
    }

    @Bean
    public LogCreateConverter logCreateConverter() {
        return new LogCreateConverterImpl();
    }

    @Bean
    public LogUpdateConverter logUpdateConverter() {
        return new LogUpdateConverterImpl();
    }

    // * ROLE * //
    @Bean
    public RoleJPAConverter roleJPAConverter(UserRepository userRepository) {
        return new RoleJPAConverterImpl(userRepository);
    }

    @Bean
    public RoleJsonConverter roleJsonConverter() {
        return new RoleJsonConverterImpl();
    }

    @Bean
    public RoleCreateConverter roleCreateConverter() {
        return new RoleCreateConverterImpl();
    }

    @Bean
    public RoleUpdateConverter roleUpdateConverter() {
        return new RoleUpdateConverterImpl();
    }

    // * TASK * //
    @Bean
    public TaskJPAConverter taskJPAConverter(UserRepository userRepository) {
        return new TaskJPAConverterImpl(userRepository);
    }

    @Bean
    public TaskJsonConverter taskJsonConverter() {
        return new TaskJsonConverterImpl();
    }

    @Bean
    public TaskCreateConverter taskCreateConverter() {
        return new TaskCreateConverterImpl();
    }

    @Bean
    public TaskUpdateConverter taskUpdateConverter() {
        return new TaskUpdateConverterImpl();
    }

    // * PROJECT * //
    @Bean
    public ProjectJPAConverter projectJPAConverter(EstablishmentRepository establishmentRepository, TaskRepository taskRepository) {
        return new ProjectJPAConverterImpl(establishmentRepository, taskRepository);
    }

    @Bean
    public ProjectJsonConverter projectJsonConverter() {
        return new ProjectJsonConverterImpl();
    }

    @Bean
    public ProjectCreateConverter projectCreateConverter() {
        return new ProjectCreateConverterImpl();
    }

    @Bean
    public ProjectUpdateConverter projectUpdateConverter() {
        return new ProjectUpdateConverterImpl();
    }

    // * ESTABLISHMENT * //
    @Bean
    public EstablishmentJPAConverter establishmentJPAConverter(UserRepository userRepository, ProjectRepository projectRepository) {
        return new EstablishmentJPAConverterImpl(userRepository, projectRepository);
    }

    @Bean
    public EstablishmentJsonConverter establishmentJsonConverter() {
        return new EstablishmentJsonConverterImpl();
    }

    @Bean
    public EstablishmentCreateConverter establishmentCreateConverter() {
        return new EstablishmentCreateConverterImpl();
    }

    @Bean
    public EstablishmentUpdateConverter establishmentUpdateConverter() {
        return new EstablishmentUpdateConverterImpl();
    }

    // * USER * //
    @Bean
    public UserJPAConverter userJPAConverter(RoleRepository roleRepository, EstablishmentRepository establishmentRepository, LogRepository logRepository) {
        return new UserJPAConverterImpl(roleRepository, establishmentRepository, logRepository);
    }

    @Bean
    public UserJsonConverter userJsonConverter() {
        return new UserJsonConverterImpl();
    }

    @Bean
    public UserCreateConverter userCreateConverter() {
        return new UserCreateConverterImpl();
    }

    @Bean
    public UserUpdateConverter userUpdateConverter() {
        return new UserUpdateConverterImpl();
    }

}
