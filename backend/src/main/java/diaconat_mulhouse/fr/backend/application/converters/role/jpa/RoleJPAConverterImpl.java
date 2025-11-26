package diaconat_mulhouse.fr.backend.application.converters.role.jpa;

import diaconat_mulhouse.fr.backend.domain.entities.role.Role;
import diaconat_mulhouse.fr.backend.domain.entities.role.RoleJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleJPAConverterImpl implements RoleJPAConverter {

    private final UserRepository userRepository;

    public RoleJPAConverterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RoleJPA fromDto(Role role) {
        return RoleJPA.builder()
                .id(role.getId())
                .title(role.getTitle())
                .users(this.userRepository.findAllById(role.getUsersId()))
                .createdAt(role.getCreatedAt())
                .build();
    }

    @Override
    public Role toDto(RoleJPA roleJPA) {
        return Role.builder()
                .id(roleJPA.getId())
                .title(roleJPA.getTitle())
                .usersId(roleJPA.getUsers().stream().map(UserJPA::getId).toList())
                .createdAt(roleJPA.getCreatedAt())
                .build();
    }
}
