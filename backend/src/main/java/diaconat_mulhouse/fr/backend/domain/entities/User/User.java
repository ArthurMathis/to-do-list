package diaconat_mulhouse.fr.backend.domain.entities.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that represents a User in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class User {

    private long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    private Long roleId;
    private List<Long> establishmentsId;
    private List<Long> tasksId;
    private List<Long> logsId;

    private LocalDateTime createAt;

}
