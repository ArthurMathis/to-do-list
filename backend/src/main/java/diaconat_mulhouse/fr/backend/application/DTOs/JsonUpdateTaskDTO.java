package diaconat_mulhouse.fr.backend.application.DTOs;

public class JsonUpdateTaskDTO {

    protected String titled;

    // * CONSTRUCTORS * //
    public JsonUpdateTaskDTO(String titled) {
        this.titled = titled;
    }

    public JsonUpdateTaskDTO() {
    }

    // * GETTERS & SETTERS * //
    public String getTitled() {
        return titled;
    }

    public void setTitled(String titled) {
        this.titled = titled;
    }
}
