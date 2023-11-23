package tn.esprit.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    String nomEt;
    String prenomEt;
    @Column(unique=true)
    Long cin;
    String ecole;
    @Temporal(TemporalType.DATE)
    LocalDate dateNaissance;
    
    @ManyToMany(mappedBy="etudiants")
    @JsonIgnore
    List<Reservation> reservations;

}
