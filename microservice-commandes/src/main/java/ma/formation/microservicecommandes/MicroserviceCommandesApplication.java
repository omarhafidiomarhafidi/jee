package ma.formation.microservicecommandes;

import ma.formation.microservicecommandes.Repositories.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
public class MicroserviceCommandesApplication  {




    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCommandesApplication.class, args);

    }



}
