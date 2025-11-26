package diaconat_mulhouse.fr.backend.infrastructure.seeders;

import diaconat_mulhouse.fr.backend.domain.entities.establishment.EstablishmentJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Order(value = 2)
public class EstablishmentSeeder implements CommandLineRunner {

    private final EstablishmentRepository establishmentRepository;
    private final SeedProperties seedProperties;
    private final Logger logger =  Logger.getLogger(EstablishmentSeeder.class.getName());

    public EstablishmentSeeder(SeedProperties seedProperties, EstablishmentRepository establishmentRepository) {
        this.seedProperties = seedProperties;
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public void run(String... args) {
        if(this.seedProperties.isEnabled() && this.establishmentRepository.count() == 0) {
            this.logger.info("Seeding establishments...");
            this.establishmentRepository.save(EstablishmentJPA.builder().name("Clinique du Diaconat Roosevelt").city("Mulhouse").postCode("68100").build());
            this.establishmentRepository.save(EstablishmentJPA.builder().name("Clinique du Diaconat Fonderie").city("Mulhouse").postCode("68100").build());
            this.establishmentRepository.save(EstablishmentJPA.builder().name("Clinique du Diaconat Colmar").city("Mulhouse").postCode("68100").build());
            this.logger.info("✅ Establishments registered in database.");
        }
    }
}
