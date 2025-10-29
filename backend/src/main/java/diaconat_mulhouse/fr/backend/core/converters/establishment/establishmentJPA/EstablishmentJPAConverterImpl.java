package diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA;

import diaconat_mulhouse.fr.backend.domain.entities.Establishment.Establishment;
import diaconat_mulhouse.fr.backend.domain.entities.Establishment.EstablishmentJPA;

public class EstablishmentJPAConverterImpl implements  EstablishmentJPAConverter {

    @Override
    public EstablishmentJPA fromDto(Establishment establishment) {
        return new EstablishmentJPA(
                establishment.getId(),
                establishment.getName(),
                establishment.getAddress(),
                establishment.getCreatedAt()
        );
    }

    @Override
    public Establishment toDto(EstablishmentJPA establishmentJPA) {
        return new Establishment(
                establishmentJPA.getId(),
                establishmentJPA.getName(),
                establishmentJPA.getAddress(),
                establishmentJPA.getCreatedAt()
        );
    }
}
