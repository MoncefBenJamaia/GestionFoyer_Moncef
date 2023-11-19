package tn.esprit.gestionfoyer.Services;

import tn.esprit.gestionfoyer.Entities.Chambre;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;


import java.util.List;

public interface IChambreServices {
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    List<Chambre> getAllChambres();
    Chambre getChambreById(Long idChambre);

    List<Chambre> getChambresParBlocEtType (Long idBloc, TypeChambre typeC) ;
}
