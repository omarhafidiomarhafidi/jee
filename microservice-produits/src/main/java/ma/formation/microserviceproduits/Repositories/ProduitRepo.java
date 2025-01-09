package ma.formation.microserviceproduits.Repositories;

import ma.formation.microserviceproduits.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Integer> {
}
