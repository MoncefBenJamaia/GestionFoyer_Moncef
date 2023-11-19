package tn.esprit.gestionfoyer.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;


import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;

    Long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeC;


    @ManyToOne
    @JoinColumn(name = "idBloc")
    Bloc bloc;

    @OneToMany
    Set<Reservation> reservations;
}
