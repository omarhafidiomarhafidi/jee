package ma.formation.microservicecommandes.Controllers;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.formation.microservicecommandes.Entities.Commande;
import ma.formation.microservicecommandes.Services.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    private CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/")
    public List<Commande> getCommandes() {
        return commandeService.getLastCommandes();
    }

    @GetMapping("/conf")
    public int getConf() {
        return commandeService.getConf();
    }


    @CircuitBreaker(name = "commandesCircuitBreaker",fallbackMethod = "defaultMessage")
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }
    public Commande defaultMessage(Throwable throwable){
        System.out.println("Fallback triggered due to: " + throwable.getMessage());
        Commande c = new Commande();
        c.setDescription("the microservice timed out !");
        return c;
    }




    @PostMapping("")
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }
    @PostMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        return commandeService.updateCommande(commande);
    }
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}
