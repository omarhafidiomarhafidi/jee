package ma.formation.microservicecommandes.Repositories;


import ma.formation.microservicecommandes.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande, Long> {
    @Query("SELECT c FROM Commande c WHERE c.date >= :date")
    List<Commande> findCommandesRecuesDerniersJours(@Param("date") LocalDate date);
}
