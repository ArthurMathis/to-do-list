package diaconat_mulhouse.fr.backend.application.converters.project.update;

import diaconat_mulhouse.fr.backend.presentation.DTOs.project.UpdateProjectDTO;
import diaconat_mulhouse.fr.backend.application.converters.Converter;
import diaconat_mulhouse.fr.backend.domain.entities.project.Project;

public interface ProjectUpdateConverter extends Converter<UpdateProjectDTO, Project> {
}
