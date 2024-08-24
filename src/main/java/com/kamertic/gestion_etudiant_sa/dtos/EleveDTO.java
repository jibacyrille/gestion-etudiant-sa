package com.kamertic.gestion_etudiant_sa.dtos;

import lombok.*;


@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class EleveDTO {
    private String nom;
    private String prenom;
    private String classe;
}
