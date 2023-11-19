package tn.esprit.gestionfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionfoyer.Entities.Bloc;


public interface IBlocRepository extends JpaRepository<Bloc, Long> {
}
