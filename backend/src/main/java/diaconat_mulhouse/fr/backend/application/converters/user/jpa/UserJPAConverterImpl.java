package diaconat_mulhouse.fr.backend.application.converters.user.jpa;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.log.LogJPA;
import diaconat_mulhouse.fr.backend.domain.entities.role.RoleJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.LogRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserJPAConverterImpl implements UserJPAConverter {

    private final RoleRepository roleRepository;
    private final EstablishmentRepository establishmentRepository;
    private final LogRepository logRepository;

    public UserJPAConverterImpl(RoleRepository roleRepository, EstablishmentRepository establishmentRepository, LogRepository logRepository) {
        this.roleRepository = roleRepository;
        this.establishmentRepository = establishmentRepository;
        this.logRepository = logRepository;
    }

    @Override
    public UserJPA fromDto(User user) {
        RoleJPA roleJPA = this.roleRepository.findById(user.getId()).orElseThrow(() -> {
            return new EntityNotFoundException("Role : " + user.getRoleId() + ", not found.");
        });

        return UserJPA.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(roleJPA)
                .establishments(this.establishmentRepository.findAllById(user.getEstablishmentsId()))
                .logs(this.logRepository.findAllById(user.getLogsId()))
                .createdAt(user.getCreateAt())
                .build();
    }

    @Override
    public User toDto(UserJPA userJPA) {
        return User.builder()
                .id(userJPA.getId())
                .lastName(userJPA.getLastName())
                .firstName(userJPA.getFirstName())
                .email(userJPA.getEmail())
                .password(userJPA.getPassword())
                .roleId(userJPA.getRole().getId())
                .establishmentsId(userJPA.getEstablishments().stream().map(EstablishmentJPA::getId).toList())
                .logsId(userJPA.getLogs().stream().map(LogJPA::getId).toList())
                .createAt(userJPA.getCreatedAt())
                .build();
    }
}
