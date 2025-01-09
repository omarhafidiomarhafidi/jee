package ma.formation.microservicecommandes.Config;

import ma.formation.microservicecommandes.Repositories.CommandeRepo;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {
    private final CommandeRepo commandeRepository;

    public CommandeHealthIndicator(CommandeRepo commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Health health() {
        long count = commandeRepository.count();
        if (count > 0) {
            return Health.up()
                    .withDetail("message", "Des commandes existent dans la table COMMANDE.")
                    .withDetail("commandeCount", count)
                    .build();
        } else {
            return Health.down()
                    .withDetail("message", "Aucune commande dans la table COMMANDE.")
                    .withDetail("commandeCount", 0)
                    .build();
        }    }
}
