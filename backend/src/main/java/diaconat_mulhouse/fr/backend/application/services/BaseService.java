package diaconat_mulhouse.fr.backend.application.services;

import java.util.List;

/**
 * Interface that represents a base Service
 *
 * @param <Id> The type of primary key
 * @param <DTO> The based DTO
 * @param <CreateDTO> The DTO for create element
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface BaseService<Id, DTO, CreateDTO> {

    /**
     * Public method that returns the list of elements
     *
     * @return The list of elements
     */
    public List<DTO> index();

    /**
     * Public method that returns an element from its primary key
     *
     * @param id Its primary key
     * @return The element
     */
    public DTO get(Id id);

    /**
     * Public method that creates a new element from a CreateDTO object
     *
     * @param createDTO The object that contains the pieces of information
     * @return The primary key of the new element
     */
    public Id create(CreateDTO createDTO);

}
