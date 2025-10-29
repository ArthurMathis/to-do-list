package diaconat_mulhouse.fr.backend.application.services.user;

import diaconat_mulhouse.fr.backend.application.DTOs.user.*;
import diaconat_mulhouse.fr.backend.application.services.CrudService;

public interface UserService extends CrudService<Long, UserJsonDTO, CreateUserDTO, UpdateUserDTO> {

    /**
     * Public method that authenticates a user in the system
     *
     * @param loginUserDTO The DTO that contains their login
     * @return The authentification token
     */
    public AuthToken authenticate(LoginUserDTO loginUserDTO);
}
