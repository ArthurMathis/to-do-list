package diaconat_mulhouse.fr.backend.application.converters.project.json;

import diaconat_mulhouse.fr.backend.presentation.DTOs.project.ProjectJsonDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;

public interface ProjectJsonConverter extends Converter<ProjectJsonDTO, Project> {
}
