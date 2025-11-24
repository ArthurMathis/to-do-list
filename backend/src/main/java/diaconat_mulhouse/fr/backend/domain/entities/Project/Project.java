package diaconat_mulhouse.fr.backend.domain.entities.Project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that represents a Project in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class Project {

    private long id;
    private String title;
    private String description;
    private Long establishmentId;
    private List<Long> tasksId;
    private LocalDateTime createdAt;

}
