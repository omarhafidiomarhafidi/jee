package ma.formation.microserviceproduits.Controllers;

import ma.formation.microserviceproduits.Entity.Produit;
import ma.formation.microserviceproduits.Services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/")
    public List<Produit> getAllProduits() {
        return produitService.findAll();
    }
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.save(produit);
    }
}
