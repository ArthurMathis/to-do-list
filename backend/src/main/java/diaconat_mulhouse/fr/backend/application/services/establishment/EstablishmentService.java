package diaconat_mulhouse.fr.backend.application.services.establishment;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.services.CrudService;

public interface EstablishmentService extends CrudService<Long, EstablishmentJsonDTO, CreateEstablishmentDTO, UpdateEstablishmentDTO> {
}
