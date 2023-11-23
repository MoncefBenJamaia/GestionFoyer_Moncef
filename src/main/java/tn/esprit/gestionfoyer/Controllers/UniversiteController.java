package tn.esprit.gestionfoyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.Entities.Universite;
import tn.esprit.gestionfoyer.Services.IUniversiteServices;


import java.util.List;

@RestController
@RequestMapping("universite")
@RequiredArgsConstructor
public class UniversiteController {

    private final IUniversiteServices universiteService;

    @PostMapping()
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping()
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping()
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @GetMapping("{idUniversite}")
    public Universite getUniversiteById(@PathVariable Long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }


    @PutMapping("{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
