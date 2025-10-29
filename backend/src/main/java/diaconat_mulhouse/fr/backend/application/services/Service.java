package diaconat_mulhouse.fr.backend.application.services;

import java.util.List;

/**
 * Interface that represents a CRUD Service
 *
 * @param <Id> The type of primary key
 * @param <DTO> The based DTO
 * @param <CreateDTO> The DTO for create element
 * @param <UpdateDTO> The DTO for update element
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface Service<Id, DTO, CreateDTO, UpdateDTO> {

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

    /**
     * Public method that updates an element from a UpdateDTO object
     *
     * @param updateDTO The object that contains the pieces of information
     */
    public void update(UpdateDTO updateDTO);

    /**
     * Public method that deletes an element from its primary key
     *
     * @param id Its primary key
     */
    public void delete(Id id);

}
