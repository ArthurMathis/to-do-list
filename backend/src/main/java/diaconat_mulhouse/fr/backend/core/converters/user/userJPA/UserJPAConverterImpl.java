package diaconat_mulhouse.fr.backend.core.converters.user.userJPA;

import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.establishment.establishmentJPA.EstablishmentJPAConverterImpl;
import diaconat_mulhouse.fr.backend.domain.entities.User.User;
import diaconat_mulhouse.fr.backend.domain.entities.User.UserJPA;

public class UserJPAConverterImpl implements UserJPAConverter {

    private final EstablishmentJPAConverter establishmentJPAConverter;

    public UserJPAConverterImpl(EstablishmentJPAConverter establishmentJPAConverter) {
        this.establishmentJPAConverter = establishmentJPAConverter;
    }

    @Override
    public UserJPA fromDto(User user) {
        return new UserJPA(
            user.getId(),
            user.getLastName(),
            user.getFirstName(),
            user.getEmail(),
            user.getPassword(),
            user.getEstablishments().stream().map(this.establishmentJPAConverter::fromDto).toList(),
            user.getCreatedAt()
        );
    }

    @Override
    public User toDto(UserJPA userJPA) {
        return new User(
            userJPA.getId(),
            userJPA.getLastName(),
            userJPA.getFirstName(),
            userJPA.getEmail(),
            userJPA.getPassword(),
            userJPA.getEstablishments().stream().map(this.establishmentJPAConverter::toDto).toList(),
            userJPA.getCreatedAt()
        );
    }
}
