package tn.esprit.gestionfoyer.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {

    @Id
    String idReservation;


    @Temporal(TemporalType.DATE)
    LocalDate AnneeUniversitaire;


    boolean estValide;


    @ManyToMany
    List<Etudiant> etudiants;

}
