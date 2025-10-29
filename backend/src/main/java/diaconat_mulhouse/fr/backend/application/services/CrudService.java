package diaconat_mulhouse.fr.backend.application.services;

/**
 * Interface that represents a CRUD Service
 *
 * @param <Id> The type of primary key
 * @param <DTO> The based DTO
 * @param <CreateDTO> The DTO for create element
 * @param <UpdateDTO> The DTO for update element
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface CrudService<Id, DTO, CreateDTO, UpdateDTO> extends BaseService<Id, DTO, CreateDTO> {

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
