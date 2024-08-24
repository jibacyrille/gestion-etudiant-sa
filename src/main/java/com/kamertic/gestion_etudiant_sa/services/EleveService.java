package com.kamertic.gestion_etudiant_sa.services;

import com.kamertic.gestion_etudiant_sa.dtos.EleveDTO;
import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import com.kamertic.gestion_etudiant_sa.repository.EleveRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Service
@Transactional
public class EleveService {
    private final EleveRepository eleveRepository;
    private final MatriculeService matriculeService;
    public EleveService(EleveRepository eleveRepository, MatriculeService matriculeService) {
        this.eleveRepository=eleveRepository;
        this.matriculeService=matriculeService;
    }

    @PostMapping(path="/init-eleve", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Eleve creerEleve(EleveDTO newEleveDTO) throws IOException {

        String matricule = matriculeService.genererMatricule();
        Eleve eleve = Eleve.builder()
                .matricule(matricule)
                .nom(newEleveDTO.getNom())
                .prenom(newEleveDTO.getPrenom())
                .classe(newEleveDTO.getClasse())
                .build();

        return eleveRepository.save(eleve);
    }
}
