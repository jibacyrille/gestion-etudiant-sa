package com.kamertic.gestion_etudiant_sa.web;

import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import com.kamertic.gestion_etudiant_sa.repository.EleveRepository;
import com.kamertic.gestion_etudiant_sa.services.EleveService;
import com.kamertic.gestion_etudiant_sa.services.MatriculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.kamertic.gestion_etudiant_sa.dtos.EleveDTO;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
//@RequestMapping("/api/eleves")
public class EleveRestController {

    private EleveService eleveService;
    private MatriculeService matriculeService;
    private EleveRepository eleveRepository;//A supprimer a la prochaine eape

    public EleveRestController(EleveRepository eleveRepository, MatriculeService matriculeService, EleveService eleveService){
        this.eleveService=eleveService;
        this.matriculeService=matriculeService;
        this.eleveRepository=eleveRepository;
    }


    @GetMapping(path="/inscription/liste")
    public List<Eleve> allPayments(){
        return eleveRepository.findAll();
    }

    @GetMapping(path="/eleves")
    public List<Eleve> allstudents(){
        return eleveRepository.findAll();
    }

   /* @PostMapping(value="/init-eleve", consumes = "multipart/form-data")
    public Eleve creerEleve(@RequestPart("formData") EleveDTO eleveDto) {
        Eleve eleve = new Eleve();
        eleve.setNom(eleveDto.getNom());
        eleve.setPrenom(eleveDto.getPrenom());
        eleve.setClasse(eleveDto.getClasse());

        // Génération du matricule
        String matricule = matriculeService.genererMatricule();
        eleve.setMatricule(matricule);

        // Sauvegarde de l'élève
        return eleveRepository.save(eleve);
    }*/

    @PostMapping(path="/init-eleve", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Eleve creerEleve(EleveDTO newEleveDTO) throws IOException {
        return this.eleveService.creerEleve(newEleveDTO);
    }
}
