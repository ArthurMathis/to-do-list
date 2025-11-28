package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.indexProjects;

import diaconat_mulhouse.fr.backend.domain.entities.project.Project;

import java.util.List;

public interface IndexProjectsByEstablishmentIdGateway {

    public List<Project> indexProject(long establishmentId);

}
