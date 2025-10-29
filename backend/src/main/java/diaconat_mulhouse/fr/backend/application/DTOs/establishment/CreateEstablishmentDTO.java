package diaconat_mulhouse.fr.backend.application.DTOs.establishment;

public class CreateEstablishmentDTO {

    private final String name;
    private final String address;

    // * CONSTRUCTOR * //
    public CreateEstablishmentDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // * GETTERS * //
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
