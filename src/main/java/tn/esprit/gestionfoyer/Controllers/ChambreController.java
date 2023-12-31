package tn.esprit.gestionfoyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.Entities.Chambre;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;
import tn.esprit.gestionfoyer.Services.IChambreServices;


import java.util.List;

@RestController
@RequestMapping("chambre")
@RequiredArgsConstructor
public class ChambreController {

    private final IChambreServices chambreService;

    @PostMapping()
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping()
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping()
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("{idChambre}")
    public Chambre getChambreById(@PathVariable Long idChambre) {
        return chambreService.getChambreById(idChambre);
    }


    @GetMapping("{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }
}
