package tn.esprit.gestionfoyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.Entities.Etudiant;
import tn.esprit.gestionfoyer.Services.IEtudiantServices;


import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController {

    private final IEtudiantServices etudiantService;

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{idEtudiant}")
    public Etudiant getEtudiantById(@PathVariable Long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @DeleteMapping("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        etudiantService.deleteEtudiant(idEtudiant);
    }
}
