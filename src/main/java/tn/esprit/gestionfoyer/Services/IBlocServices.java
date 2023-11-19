package tn.esprit.gestionfoyer.Services;

import tn.esprit.gestionfoyer.Entities.Bloc;


import java.util.List;

public interface IBlocServices {
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    List<Bloc> getAllBlocs();
    Bloc getBlocById(Long idBloc);
    void deleteBloc(Long idBloc);

    Bloc affecterChambresABloc(List<Long> idChambre, Long idBloc);
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) ;
}
