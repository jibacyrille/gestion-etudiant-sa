package com.kamertic.gestion_etudiant_sa.dtos;

import com.kamertic.gestion_etudiant_sa.entities.PaymentStatus;
import com.kamertic.gestion_etudiant_sa.entities.PaymentType;
import com.kamertic.gestion_etudiant_sa.entities.Student;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
    private Student student;

}
