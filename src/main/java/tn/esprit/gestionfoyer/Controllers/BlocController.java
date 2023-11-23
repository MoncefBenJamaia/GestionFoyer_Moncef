package tn.esprit.gestionfoyer.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.Entities.Bloc;
import tn.esprit.gestionfoyer.Services.IBlocServices;


import java.util.List;

@RestController
@RequestMapping("bloc")
@RequiredArgsConstructor
public class BlocController {

    private final IBlocServices blocService;

    @PostMapping()
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping()
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping()
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @GetMapping("{idBloc}")
    public Bloc getBlocById(@PathVariable Long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc) {
        blocService.deleteBloc(idBloc);
    }


    @PutMapping("/affecterChambres/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> idChambre, @PathVariable Long idBloc) {
        return blocService.affecterChambresABloc(idChambre, idBloc);
    }
    @PutMapping("{idBloc}/{idFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return blocService.affecterBlocAFoyer(idBloc, idFoyer);
    }
}
