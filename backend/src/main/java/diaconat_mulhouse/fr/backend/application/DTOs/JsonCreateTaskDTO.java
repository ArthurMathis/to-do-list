package diaconat_mulhouse.fr.backend.application.DTOs;

public class JsonCreateTaskDTO {

    protected String titled;

    public JsonCreateTaskDTO(String titled) {
        this.titled = titled;
    }

    public String getTitled() {
        return titled;
    }

    public void setTitled(String titled) {
        this.titled = titled;
    }
}
