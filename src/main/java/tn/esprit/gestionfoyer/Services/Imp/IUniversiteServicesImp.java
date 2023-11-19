package tn.esprit.gestionfoyer.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.Entities.Foyer;
import tn.esprit.gestionfoyer.Entities.Universite;
import tn.esprit.gestionfoyer.Repositories.*;
import tn.esprit.gestionfoyer.Services.IUniversiteServices;


import java.util.List;

@Service
@RequiredArgsConstructor
public class IUniversiteServicesImp implements IUniversiteServices {

    private final IUniversiteRepository universiteRepository;
    private final IFoyerRepository foyerRepository;


    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }


    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }


}
