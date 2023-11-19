package tn.esprit.gestionfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionfoyer.Entities.Universite;


public interface IUniversiteRepository extends JpaRepository<Universite, Long>  {
    Universite findByNomUniversite(String nomUniversite);
}
