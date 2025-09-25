package diaconat_mulhouse.fr.backend.application.DTOs;

public class TaskJsonDTO {

    protected long id;
    protected String titled;
    protected boolean checked;

    public TaskJsonDTO(long id, String titled, boolean checked) {
        this.id = id;
        this.titled = titled;
        this.checked = checked;
    }

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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
