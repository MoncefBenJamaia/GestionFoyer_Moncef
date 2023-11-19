package tn.esprit.gestionfoyer.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.Entities.Etudiant;
import tn.esprit.gestionfoyer.Repositories.IEtudiantRepository;
import tn.esprit.gestionfoyer.Services.IEtudiantServices;


import java.util.List;

@Service
@RequiredArgsConstructor
public class IEtudiantServicesImp implements IEtudiantServices {

    private final IEtudiantRepository etudiantRepository;


    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
