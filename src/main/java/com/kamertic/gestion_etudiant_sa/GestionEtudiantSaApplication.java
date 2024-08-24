package com.kamertic.gestion_etudiant_sa;

import com.kamertic.gestion_etudiant_sa.entities.Payment;
import com.kamertic.gestion_etudiant_sa.entities.PaymentStatus;
import com.kamertic.gestion_etudiant_sa.entities.PaymentType;
import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import com.kamertic.gestion_etudiant_sa.repository.PaymentRepository;
import com.kamertic.gestion_etudiant_sa.repository.EleveRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GestionEtudiantSaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEtudiantSaApplication.class, args);
	}

}
