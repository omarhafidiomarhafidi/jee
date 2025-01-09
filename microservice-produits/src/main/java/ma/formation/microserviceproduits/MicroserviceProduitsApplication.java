package ma.formation.microserviceproduits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties
public class MicroserviceProduitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProduitsApplication.class, args);
    }

}
