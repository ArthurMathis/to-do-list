package diaconat_mulhouse.fr.backend.application.services.user;

import diaconat_mulhouse.fr.backend.application.DTOs.user.*;
import diaconat_mulhouse.fr.backend.application.services.Service;

public interface UserService extends Service<Long, UserJsonDTO, CreateUserDTO, UpdateUserDTO> {

    /**
     * Public method that authenticates a user in the system
     *
     * @param loginUserDTO The DTO that contains their login
     * @return The authentification token
     */
    public AuthToken authenticate(LoginUserDTO loginUserDTO);
}
