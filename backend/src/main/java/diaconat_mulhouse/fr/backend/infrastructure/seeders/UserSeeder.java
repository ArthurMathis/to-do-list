package diaconat_mulhouse.fr.backend.infrastructure.seeders;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.entities.role.RoleJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.RoleRepository;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Component
@Order(value = 3)
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EstablishmentRepository establishmentRepository;
    private final SeedProperties seedProperties;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = Logger.getLogger(UserSeeder.class.getName());

    public UserSeeder(
            SeedProperties seedProperties,
            UserRepository userRepository,
            RoleRepository roleRepository,
            EstablishmentRepository establishmentRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.seedProperties = seedProperties;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.establishmentRepository = establishmentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws EntityNotFoundException {
        if(this.seedProperties.isEnabled() && this.userRepository.count() == 0) {
            this.logger.info("Seeding users...");

            // Data fetch
            RoleJPA ownerJPA = this.roleRepository.findById(1L).orElseThrow(() -> {
                return new EntityNotFoundException("Role 1 not found.");
            });
            RoleJPA adminJPA = this.roleRepository.findById(2L).orElseThrow(() -> {
                return new EntityNotFoundException("Role 2 not found.");
            });
            List<EstablishmentJPA> establishments = this.establishmentRepository.findAll();

            // User registering
            this.userRepository.save(
                    UserJPA.builder()
                            .lastName(this.seedProperties.getOwner().getLastname())
                            .firstName(this.seedProperties.getOwner().getFirstname())
                            .email(this.seedProperties.getOwner().getEmail())
                            .password(this.passwordEncoder.encode(this.seedProperties.getOwner().getPassword()))
                            .role(ownerJPA)
                            .establishments(establishments)
                            .build()
            );
            this.userRepository.save(
                    UserJPA.builder()
                            .lastName(this.seedProperties.getAdmin().getLastname())
                            .firstName(this.seedProperties.getAdmin().getFirstname())
                            .email(this.seedProperties.getAdmin().getEmail())
                            .password(this.passwordEncoder.encode(this.seedProperties.getAdmin().getPassword()))
                            .role(adminJPA)
                            .establishments(establishments)
                            .build()
            );
            this.logger.info("✅ Users registered in database.");
        }
    }
}
