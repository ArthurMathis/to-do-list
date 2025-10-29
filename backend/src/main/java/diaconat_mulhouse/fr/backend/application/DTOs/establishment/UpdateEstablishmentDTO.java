package diaconat_mulhouse.fr.backend.application.DTOs.establishment;

public class UpdateEstablishmentDTO {

    private final long id;
    private final String name;
    private final String address;

    // * CONSTRUCTOR * //
    public UpdateEstablishmentDTO(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // * GETTERS * //
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
