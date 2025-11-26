package diaconat_mulhouse.fr.backend.domain.entities.logType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that represents a LogType in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Getter
@Setter
@Builder
public class LogType {

    private long id;
    private String title;
    private List<Long> logsId;
    private LocalDateTime createdAt;

}
