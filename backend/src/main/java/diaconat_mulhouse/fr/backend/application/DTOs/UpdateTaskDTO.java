package diaconat_mulhouse.fr.backend.application.DTOs;

public class UpdateTaskDTO {

    protected long id;
    protected String titled;

    // * CONSTRUCTORS * //
    public UpdateTaskDTO(long id, String titled) {
        this.id = id;
        this.titled = titled;
    }

    public UpdateTaskDTO() {
    }

    // * GETTERS & SETTERS * //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitled() {
        return titled;
    }

    public void setTitled(String titled) {
        this.titled = titled;
    }
}
