package tn.esprit.gestionfoyer.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.gestionfoyer.Entities.*;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;
import tn.esprit.gestionfoyer.Repositories.*;
import tn.esprit.gestionfoyer.Services.IReservationServices;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IReservationServicesImp implements IReservationServices {

    private final IReservationRepository reservationRepository;
    private final IEtudiantRepository etudiantRepository;
    private final IChambreRepository chambreRepository;



    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }


    @Override
    public Reservation ajouterReservation (Long idChambre, Long cin)  {
        Chambre chambre = chambreRepository.findById(idChambre).orElseThrow(()->new IllegalArgumentException("Cette chambre n'existe pas"));

        Etudiant etudiant = etudiantRepository.findByCin(cin);

        // Création de la réservation
        Reservation reservation = new Reservation();
        assert chambre != null;
        reservation.setIdReservation(chambre.getNumeroChambre() +"-"+ chambre.getBloc().getNomBloc().replace(" ", "") +"-"+ cin+"-"+LocalDate.now().getYear());
        reservation.setAnneeUniversitaire(LocalDate.now());
        reservation.setEstValide(true);

        // Déterminer la capacité maximale en fonction du type de chambre
        int capaciteMax = 0;
        if (TypeChambre.SIMPLE.equals(chambre.getTypeC())) {
            capaciteMax = 1;
        } else if (TypeChambre.DOUBLE.equals(chambre.getTypeC())) {
            capaciteMax = 2;
        } else if (TypeChambre.TRIPLE.equals(chambre.getTypeC())) {
            capaciteMax = 3;
        }

        // Vérifier si la capacité maximale de la chambre est atteinte
        List<Reservation> reservations=chambre.getReservations();
        List<Reservation> reservationNow=new ArrayList<>();
        for (Reservation r:reservations){
            if (r.getAnneeUniversitaire().getYear()==LocalDate.now().getYear()){
                reservationNow.add(r);
            }
        }
        long nombreReservations = reservationNow.size();
        if (nombreReservations >= capaciteMax) {
            throw new IllegalStateException("La capacité maximale de la chambre est atteinte.");
        }

        // Gérer la relation ManyToMany
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);

        // Sauvegarder la réservation
        Reservation savedReservation = reservationRepository.save(reservation);

        // Ajouter la réservation à la collection de réservations de la chambre et sauvegarder
        chambre.getReservations().add(savedReservation);
        chambreRepository.save(chambre);

        return savedReservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(Long cinEtudiant) {
        // Trouver l'étudiant et sa réservation
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        Reservation reservation = etudiant.getReservations().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);


        reservation.setEstValide(false);

        reservation.getEtudiants().remove(etudiant);


        Chambre chambreAssociee = chambreRepository.findByReservationsContains(reservation);
        if (chambreAssociee != null) {
            chambreAssociee.getReservations().remove(reservation);
            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return reservationRepository.save(reservation);
    }
}
