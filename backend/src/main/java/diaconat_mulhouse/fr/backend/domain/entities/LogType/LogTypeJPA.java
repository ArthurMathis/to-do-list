package diaconat_mulhouse.fr.backend.domain.entities.LogType;

import diaconat_mulhouse.fr.backend.domain.entities.Log.LogJPA;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "logs_types")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class LogTypeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "logs", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LogJPA> logs = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public LogTypeJPA(Long id, String title, List<LogJPA> logs, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.logs = logs;
        this.createdAt = createdAt;
    }

}
