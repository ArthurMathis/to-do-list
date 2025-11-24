package diaconat_mulhouse.fr.backend.domain.entities.Establishment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that represents a Establishment in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class Establishment {

    private long id;
    private String name;
    private String city;
    private String postCode;

    private List<Long> projectsId;
    private List<Long> usersId;

    private LocalDateTime createdAt;

}
