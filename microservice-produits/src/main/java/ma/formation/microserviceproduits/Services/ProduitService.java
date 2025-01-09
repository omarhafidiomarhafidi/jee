package ma.formation.microserviceproduits.Services;

import ma.formation.microserviceproduits.Entity.Produit;
import ma.formation.microserviceproduits.Repositories.ProduitRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private ProduitRepo produitRepo;

    public ProduitService(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    public List<Produit> findAll() {
        return produitRepo.findAll();
    }
    public Produit findById(int id) {
        return produitRepo.findById(id).get();
    }
    public Produit save(Produit produit) {
        return produitRepo.save(produit);
    }
    public Produit update(Produit produit) {
        return produitRepo.save(produit);
    }
    public void delete(int id) {
        produitRepo.deleteById(id);
    }

}
