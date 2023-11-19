package tn.esprit.gestionfoyer.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.gestionfoyer.Entities.*;
import tn.esprit.gestionfoyer.Repositories.*;
import tn.esprit.gestionfoyer.Services.IFoyerServices;


import java.util.List;

@Service
@RequiredArgsConstructor
public class IFoyerServicesImp implements IFoyerServices {

    private final IFoyerRepository foyerRepository;
    private final IUniversiteRepository universiteRepository;
    private final IBlocRepository blocRepository;


    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        universite.setFoyer(foyer);

        for (Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }

        return foyer;
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyerById(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
