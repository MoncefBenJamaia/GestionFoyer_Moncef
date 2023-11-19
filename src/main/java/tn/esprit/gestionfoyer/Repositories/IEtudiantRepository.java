package tn.esprit.gestionfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionfoyer.Entities.Etudiant;


public interface IEtudiantRepository extends JpaRepository<Etudiant, Long>  {
    Etudiant findByCin(Long cin);
}
