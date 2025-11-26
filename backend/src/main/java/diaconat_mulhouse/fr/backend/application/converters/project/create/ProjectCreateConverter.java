package diaconat_mulhouse.fr.backend.application.converters.project.create;

import diaconat_mulhouse.fr.backend.presentation.DTOs.project.CreateProjectDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;

public interface ProjectCreateConverter extends Converter<CreateProjectDTO, Project> {
}
