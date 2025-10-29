package diaconat_mulhouse.fr.backend.domain.entities.Log;

import diaconat_mulhouse.fr.backend.domain.entities.LogType.LogType;
import diaconat_mulhouse.fr.backend.domain.entities.LogableEntity;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;

import java.util.HashMap;

public class Log {

    private final long id;
    private final LogType logType;
    private final User user;
    private final LogableEntity logableEntity;
    private final HashMap<String, String> details;
    private final String ipAddress;

    // * CONSTRUCTOR * //
    public Log(long id, LogType logType, User user, LogableEntity logableEntity, HashMap<String, String> details, String ipAddress) {
        this.id = id;
        this.logType = logType;
        this.user = user;
        this.logableEntity = logableEntity;
        this.details = details;
        this.ipAddress = ipAddress;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public LogType getLogType() {
        return logType;
    }

    public User getUser() {
        return user;
    }

    public LogableEntity getLogableEntity() {
        return logableEntity;
    }

    public HashMap<String, String> getDetails() {
        return details;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
