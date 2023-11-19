package tn.esprit.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;

    String nomFoyer;
    Long capaciteFoyer;


    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    Universite universite;

    @OneToMany(mappedBy = "foyer", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    Set<Bloc> blocs;

}
