package tn.esprit.gestionfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionfoyer.Entities.Foyer;


public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
}
