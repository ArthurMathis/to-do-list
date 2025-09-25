package diaconat_mulhouse.fr.backend.domain.entities;

/**
 * Class that represents a Task in the API
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public class Task {

    private long id;
    private String titled;
    private boolean checked;

    public Task(long id, String titled, boolean checked) {
        this.id = id;
        this.titled = titled;
        this.checked = checked;
    }

    public Task(long id, String titled) {
        this(id, titled, false);
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
