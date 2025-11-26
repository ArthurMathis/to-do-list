package diaconat_mulhouse.fr.backend.domain.entities.logType;

import diaconat_mulhouse.fr.backend.domain.entities.log.LogJPA;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "logs_types")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogTypeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "logType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LogJPA> logs = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}
