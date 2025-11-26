package diaconat_mulhouse.fr.backend.application.converters.establishment.jpa;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.project.ProjectJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.ProjectRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class EstablishmentJPAConverterImpl implements EstablishmentJPAConverter {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public EstablishmentJPAConverterImpl(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public EstablishmentJPA fromDto(Establishment establishment) {
        return EstablishmentJPA.builder()
                .id(establishment.getId())
                .name(establishment.getName())
                .city(establishment.getCity())
                .postCode(establishment.getPostCode())
                .users(this.userRepository.findAllById(establishment.getUsersId()))
                .projects(this.projectRepository.findAllById(establishment.getProjectsId()))
                .createdAt(establishment.getCreatedAt())
                .build();
    }

    @Override
    public Establishment toDto(EstablishmentJPA establishmentJPA) {
        return Establishment.builder()
                .id(establishmentJPA.getId())
                .name(establishmentJPA.getName())
                .city(establishmentJPA.getCity())
                .postCode(establishmentJPA.getPostCode())
                .usersId(establishmentJPA.getUsers().stream().map(UserJPA::getId).toList())
                .projectsId(establishmentJPA.getProjects().stream().map(ProjectJPA::getId).toList())
                .createdAt(establishmentJPA.getCreatedAt())
                .build();
    }
}
