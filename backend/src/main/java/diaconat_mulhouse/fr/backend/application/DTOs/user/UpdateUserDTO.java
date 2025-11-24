package diaconat_mulhouse.fr.backend.application.DTOs.user;

import lombok.Builder;

import java.util.List;

@Builder
public record UpdateUserDTO(long id, String firstName, String lastName, String email, String password,
                            long roleId, List<Long> establishmentsId, List<Long> tasksId) {

    // * CONSTRUCTOR * //
}
