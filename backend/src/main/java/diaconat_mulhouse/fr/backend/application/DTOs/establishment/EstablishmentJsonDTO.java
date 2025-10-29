package diaconat_mulhouse.fr.backend.application.DTOs.establishment;

import java.time.LocalDateTime;

public class EstablishmentJsonDTO {

    private final long id;
    private final String name;
    private final String address;
    private final LocalDateTime createAt;

    // * CONSTRUCTOR * //
    public EstablishmentJsonDTO(long id, String name, String address, LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createAt = createAt;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}
