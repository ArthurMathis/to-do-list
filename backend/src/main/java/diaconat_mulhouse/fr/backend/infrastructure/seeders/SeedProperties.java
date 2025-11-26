package diaconat_mulhouse.fr.backend.infrastructure.seeders;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@Getter
@ConfigurationProperties(prefix = "data.seed")
public class SeedProperties {

    private boolean enabled;

    private UserSeed owner = new UserSeed();
    private UserSeed admin = new UserSeed();

    @Data
    public static class UserSeed {
        private String lastname;
        private String firstname;
        private String email;
        private String password;
    }

}
