package com.kamertic.gestion_etudiant_sa.repository;

import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve, String> {
    /*interface basée sur spring data donc on aura besoin d'heriter de JpaRepository.
     L'entité a gerer ici c'est Student et son id est de type string*/
    //Eleve findByMatricule(String matricule);
    //List<Eleve> findByProgramId(String programId);


    @Query("SELECT e FROM Eleve e WHERE e.matricule = (SELECT MAX(matricule) FROM Eleve)")
    Eleve findEleveWithHighestMatricule();
}
