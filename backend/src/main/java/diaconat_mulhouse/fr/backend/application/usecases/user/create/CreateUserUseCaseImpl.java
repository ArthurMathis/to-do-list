package diaconat_mulhouse.fr.backend.application.usecases.user.create;

import diaconat_mulhouse.fr.backend.infrastructure.gateways.user.create.CreateUserGateway;
import diaconat_mulhouse.fr.backend.domain.entities.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;
    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway, PasswordEncoder passwordEncoder) {
        this.createUserGateway = createUserGateway;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long execute(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.createUserGateway.create(user);
    }
}
