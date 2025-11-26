package diaconat_mulhouse.fr.backend.infrastructure.seeders;

import diaconat_mulhouse.fr.backend.domain.entities.role.RoleJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Component
@Order(value = 1)
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final SeedProperties seedProperties;
    private final Logger logger =  Logger.getLogger(RoleSeeder.class.getName());

    public RoleSeeder(SeedProperties seedProperties, RoleRepository roleRepository) {
        this.seedProperties = seedProperties;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if(this.seedProperties.isEnabled() && this.roleRepository.count() == 0) {
            this.logger.info("Seeding roles...");
            this.roleRepository.save(RoleJPA.builder().title("owner").build());
            this.roleRepository.save(RoleJPA.builder().title("administrator").build());
            this.roleRepository.save(RoleJPA.builder().title("moderator").build());
            this.roleRepository.save(RoleJPA.builder().title("user").build());
            this.logger.info("✅ Roles registered in database.");
        }
    }
}
