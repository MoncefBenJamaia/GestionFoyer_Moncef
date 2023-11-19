package tn.esprit.gestionfoyer.Services;

import tn.esprit.gestionfoyer.Entities.Reservation;


import java.util.List;

public interface IReservationServices {
    Reservation updateReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(String idReservation);

    Reservation ajouterReservation (Long idChambre, Long cinEtudiant) ;
    Reservation annulerReservation (Long cinEtudiant) ;
}
