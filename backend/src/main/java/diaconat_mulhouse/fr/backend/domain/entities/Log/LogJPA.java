package diaconat_mulhouse.fr.backend.domain.entities.Log;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogTypeJPA;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
public class LogJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String details;
    private String ipAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_type_id")
    private LogTypeJPA logType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserJPA user;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public LogJPA(Long id, String details, String ipAddress, LogTypeJPA logType, UserJPA user, LocalDateTime createdAt) {
        this.id = id;
        this.logType = logType;
        this.user = user;
        this.ipAddress = ipAddress;
        this.details = details;
        this.createdAt = createdAt;
    }

}
