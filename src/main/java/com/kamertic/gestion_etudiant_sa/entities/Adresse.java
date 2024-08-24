package com.kamertic.gestion_etudiant_sa.entities;

import jakarta.persistence.*;
import lombok.*;

//import java.util.Date;
import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pays;
    private String ville;
    private String rue;
    private String codePostal;

    // Getters and Setters
}
