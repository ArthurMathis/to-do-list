package diaconat_mulhouse.fr.backend.domain.entities.Log;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogTypeJPA;
import diaconat_mulhouse.fr.backend.domain.entities.LogableJpaEntity;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashMap;

@Entity
public class LogJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private LogTypeJPA logType;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserJPA user;

    private String ipAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    private LogableJpaEntity logableEntity;

    @Column(columnDefinition = "TEXT")
    private String details;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // * CONSTRUCTOR * //
    public LogJPA(Long id, LogTypeJPA logType, UserJPA user, String ipAddress, LogableJpaEntity logableEntity, String details, LocalDateTime createdAt) {
        this.id = id;
        this.logType = logType;
        this.user = user;
        this.ipAddress = ipAddress;
        this.logableEntity = logableEntity;
        this.details = details;
        this.createdAt = createdAt;
    }

    public LogJPA() {
    }

    // * GETTERS * //
    public Long getId() {
        return id;
    }

    public LogTypeJPA getLogType() {
        return logType;
    }

    public UserJPA getUser() {
        return user;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LogableJpaEntity getLogableEntity() {
        return logableEntity;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
