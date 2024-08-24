package com.kamertic.gestion_etudiant_sa.services;


import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import com.kamertic.gestion_etudiant_sa.repository.EleveRepository;
import com.kamertic.gestion_etudiant_sa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MatriculeService {

    @Value("${matricule.initial}")
    private int matriculeInitial;

    @Value("${matricule.base}")
    private String BASE_MATRICULE;

    private EleveRepository eleveRepository;


    public MatriculeService(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    public String genererMatricule() {
        // Récupérer l'élève avec le matricule le plus élevé
        Eleve dernierEleve = eleveRepository.findEleveWithHighestMatricule();

        String nouveauMatricule;
        if (dernierEleve != null && dernierEleve.getMatricule().length() >= 4) {
            // Extraire les quatre derniers caractères du matricule actuel
            String lastFourDigits = dernierEleve.getMatricule().substring(dernierEleve.getMatricule().length() - 4);

            try {
                // Convertir les quatre derniers caractères en entier
                int lastNumber = Integer.parseInt(lastFourDigits);

                // Incrémenter l'entier
                int nouveauNumero = lastNumber + 1;

                // Construire le nouveau matricule
                nouveauMatricule = BASE_MATRICULE + String.format("%04d", nouveauNumero);
            } catch (NumberFormatException e) {
                // En cas d'erreur de formatage, réinitialiser le compteur
                nouveauMatricule = BASE_MATRICULE + "0001";
            }
        } else {
            // Si aucun élève n'existe ou matricule non valide, commencer à "0001"
            nouveauMatricule = BASE_MATRICULE + "0001";
        }

        return nouveauMatricule;
    }
}