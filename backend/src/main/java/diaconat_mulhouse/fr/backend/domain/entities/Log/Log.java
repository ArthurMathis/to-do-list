package diaconat_mulhouse.fr.backend.domain.entities.Log;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Class that represents a Log in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class Log {

    private long id;
    private HashMap<String, String> details;
    private String ipAddress;
    private Long logTypeId;
    private Long userId;
    private LocalDateTime createdAt;

}
