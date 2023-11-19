package tn.esprit.gestionfoyer.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.Entities.*;
import tn.esprit.gestionfoyer.Repositories.*;
import tn.esprit.gestionfoyer.Services.IBlocServices;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IBlocServicesImp implements IBlocServices {

    private final IBlocRepository blocRepository;
    private final IChambreRepository chambreRepository;
    private final IFoyerRepository foyerRepository;



    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }


    @Override
    public Bloc affecterChambresABloc(List<Long> idChambre, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        for(Long id:idChambre){
            Chambre chambre = chambreRepository.findById(id).orElse(null);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
        return bloc;
    }
}
