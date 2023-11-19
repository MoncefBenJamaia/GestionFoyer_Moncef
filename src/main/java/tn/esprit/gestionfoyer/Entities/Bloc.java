package tn.esprit.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bloc  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;

    String nomBloc;

    Long capaciteBloc;


    @ManyToOne
    @JsonIgnore
    Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    @JsonIgnore
    List<Chambre> chambres;

}
