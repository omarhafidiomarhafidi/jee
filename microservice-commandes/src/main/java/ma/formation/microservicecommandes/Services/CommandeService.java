package ma.formation.microservicecommandes.Services;


import ma.formation.microservicecommandes.Config.CommandeConfig;
import ma.formation.microservicecommandes.Config.ProduitFeignClient;
import ma.formation.microservicecommandes.Entities.Commande;
import ma.formation.microservicecommandes.Entities.ProduitDTO;
import ma.formation.microservicecommandes.Repositories.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    private ProduitFeignClient produitFeignClient;
    private CommandeRepo commandeRepo;
    private CommandeConfig commandeConfig;

    public CommandeService(ProduitFeignClient produitFeignClient, CommandeRepo commandeRepo, CommandeConfig commandeConfig) {
        this.produitFeignClient = produitFeignClient;
        this.commandeRepo = commandeRepo;
        this.commandeConfig = commandeConfig;
    }


    public List<Commande> getAllCommandes() {
        return commandeRepo.findAll();
    }
    public Commande getCommandeById(Long id) {
        return commandeRepo.findById(id).get();
    }
    public Commande addCommande(Commande commande) {
        ProduitDTO produitDTO = produitFeignClient.getProduitById(commande.getId_produit());
        if (produitDTO == null) {            throw new RuntimeException("Produit not found!");
        }
        commande.setMontant(produitDTO.getPrix()*commande.getQuantite());
        return commandeRepo.save(commande);
    }
    public Commande updateCommande(Commande commande) {
        return commandeRepo.save(commande);
    }
    public void deleteCommande(Long id) {
        commandeRepo.delete(getCommandeById(id));
    }

    public List<Commande> getLastCommandes(){
        return commandeRepo.findCommandesRecuesDerniersJours(LocalDate.now().minusDays(commandeConfig.getNmbrOfDays()));
    }
    public int getConf(){
        return commandeConfig.getNmbrOfDays();}

}
