package tn.esprit.gestionfoyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.Entities.Chambre;
import tn.esprit.gestionfoyer.Entities.Enum.TypeChambre;
import tn.esprit.gestionfoyer.Services.IChambreServices;


import java.util.List;

@RestController
@RequestMapping("/chambre")
@RequiredArgsConstructor
public class ChambreController {

    private final IChambreServices chambreService;

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/all")
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/{idChambre}")
    public Chambre getChambreById(@PathVariable Long idChambre) {
        return chambreService.getChambreById(idChambre);
    }


    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }
}
