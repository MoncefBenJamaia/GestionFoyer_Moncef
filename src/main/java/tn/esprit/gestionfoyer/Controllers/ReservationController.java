package tn.esprit.gestionfoyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.Entities.Reservation;
import tn.esprit.gestionfoyer.Services.IReservationServices;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationServices reservationService;


    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{idReservation}")
    public Reservation getReservationById(@PathVariable String idReservation) {
        return reservationService.getReservationById(idReservation);
    }


    @PostMapping("/add/{idChambre}/{cin}")
    public Reservation ajouterReservation(@PathVariable Long idChambre, @PathVariable Long cin) {
        return reservationService.ajouterReservation(idChambre, cin);
    }

    @PutMapping("/annulerReservation/{cin}")
    public Reservation annulerReservation(@PathVariable Long cin) {
        return reservationService.annulerReservation(cin);
    }
}
