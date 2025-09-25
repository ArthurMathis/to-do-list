package diaconat_mulhouse.fr.backend.application.DTOs;

public class CreateTaskDTO {

    protected String titled;

    public CreateTaskDTO(String titled) {
        this.titled = titled;
    }

    public CreateTaskDTO() {
    }

    public String getTitled() {
        return titled;
    }

    public void setTitled(String titled) {
        this.titled = titled;
    }
}
