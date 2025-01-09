package ma.formation.microservicecommandes.Config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "mes-config.ms")

@RefreshScope
public class CommandeConfig {
    private int nmbrOfDays ;


    public int getNmbrOfDays() {
        return nmbrOfDays;
    }

    public void setNmbrOfDays(int nmbrOfDays) {
        this.nmbrOfDays = nmbrOfDays;
    }
}
