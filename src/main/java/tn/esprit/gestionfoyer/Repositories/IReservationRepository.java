package tn.esprit.gestionfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionfoyer.Entities.Reservation;


public interface IReservationRepository extends JpaRepository<Reservation, String>  {
}
