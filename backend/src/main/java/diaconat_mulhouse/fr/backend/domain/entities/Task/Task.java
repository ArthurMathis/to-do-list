package diaconat_mulhouse.fr.backend.domain.entities.Task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that represents a Task in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class Task {

    private long id;

    private String titled;
    private String description;
    private boolean checked;

    private Long projectId;
    private List<Long> usersId;

    private LocalDateTime createdAt;

}
