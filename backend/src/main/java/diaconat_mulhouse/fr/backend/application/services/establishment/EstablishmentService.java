package diaconat_mulhouse.fr.backend.application.services.establishment;

import diaconat_mulhouse.fr.backend.application.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.services.Service;

public interface EstablishmentService extends Service<Long, EstablishmentJsonDTO, CreateEstablishmentDTO, UpdateEstablishmentDTO> {
}
