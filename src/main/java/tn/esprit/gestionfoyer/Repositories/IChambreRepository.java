package tn.esprit.gestionfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.gestionfoyer.Entities.Chambre;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;
import tn.esprit.gestionfoyer.Entities.Reservation;


import java.util.List;

public interface IChambreRepository extends JpaRepository<Chambre, Long>  {
    //Solution 1
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC);

    //Solution 2
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);

    Chambre findByReservationsContains(Reservation reservation);
}
