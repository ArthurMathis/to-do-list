package diaconat_mulhouse.fr.backend.infrastructure.gateways.establishment.get;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.Establishment;

public interface GetEstablishmentGateway {

    public Establishment get(long id);

}
