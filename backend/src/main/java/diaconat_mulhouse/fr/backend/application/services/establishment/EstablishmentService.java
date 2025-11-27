package diaconat_mulhouse.fr.backend.application.services.establishment;

import diaconat_mulhouse.fr.backend.application.services.CrudService;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.UpdateEstablishmentDTO;

import java.util.List;

public interface EstablishmentService extends CrudService<Long, EstablishmentJsonDTO, CreateEstablishmentDTO, UpdateEstablishmentDTO> {

    /**
     * Public method hat returns the user's list of establishments
     *
     * @return The user's list of establishments
     */
    public List<EstablishmentJsonDTO> indexByUserId(Long userId);

}
