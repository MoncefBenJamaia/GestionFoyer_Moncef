package tn.esprit.gestionfoyer.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.Entities.Chambre;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;
import tn.esprit.gestionfoyer.Repositories.IChambreRepository;
import tn.esprit.gestionfoyer.Services.IChambreServices;


import java.util.List;

@Service
@RequiredArgsConstructor
public class IChambreServicesImp implements IChambreServices {

    private final IChambreRepository chambreRepository;


    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre getChambreById(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {
        return chambreRepository.getChambresParBlocEtType(idBloc, typeC);  //Solution 1
    }

}
