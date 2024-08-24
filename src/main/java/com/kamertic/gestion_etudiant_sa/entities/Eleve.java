package com.kamertic.gestion_etudiant_sa.entities;

import jakarta.persistence.*;
import lombok.*;

//import java.util.Date;
import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricule;
    private String nom;
    private String prenom;
    private String classe;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String observations;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "tuteur_id")
    private Tuteur tuteur;

    // Nouveau champ pour stocker le nom du fichier photo
    private String nomPhoto;
}
