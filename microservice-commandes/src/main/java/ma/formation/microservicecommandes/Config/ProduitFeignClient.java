package ma.formation.microservicecommandes.Config;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.formation.microservicecommandes.Entities.ProduitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-produits")
public interface ProduitFeignClient {

    @CircuitBreaker(name = "commandesCircuitBreaker",fallbackMethod = "defaultMessagee")
    @GetMapping("api/produits/{id}")
    ProduitDTO getProduitById(@PathVariable Long id);

     default ProduitDTO defaultMessagee(Throwable throwable){
         System.out.println(throwable.getMessage());
         ProduitDTO produitDTO = new ProduitDTO();
         produitDTO.setId(111111);
         return produitDTO;
     }
}
