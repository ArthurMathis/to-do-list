package diaconat_mulhouse.fr.backend.domain.entities.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that represents a user Role in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class Role {

    private long id;
    private String title;
    private List<Long> usersId;
    private LocalDateTime createdAt;

}
