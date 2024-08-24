package com.kamertic.gestion_etudiant_sa;

import com.kamertic.gestion_etudiant_sa.entities.Payment;
import com.kamertic.gestion_etudiant_sa.entities.PaymentStatus;
import com.kamertic.gestion_etudiant_sa.entities.PaymentType;
import com.kamertic.gestion_etudiant_sa.entities.Student;
import com.kamertic.gestion_etudiant_sa.repository.PaymentRepository;
import com.kamertic.gestion_etudiant_sa.repository.StudentRepository;
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

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
										PaymentRepository paymentRepository){
		return args->{
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Mohamed").lastName("Nsangou").code("112233").programId("SDIA")
					.build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Imane").lastName("Hycham").code("112244").programId("SDIA")
					.build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Yasmine").lastName("Sebri").code("112255").programId("GLSID")
					.build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
					.firstName("Cyrille").lastName("Jiba").code("112266").programId("MI")
					.build());

			PaymentType[] paymentTypes=PaymentType.values();
			Random random=new Random();
			studentRepository.findAll().forEach(st->{
				for(int i=0; i<10; i++){
					int index=random.nextInt(paymentTypes.length);
					Payment payment=Payment.builder()
							.amount(1000+(int)(Math.random()*20000))
							.type(paymentTypes[index])
							.status(PaymentStatus.CREATED)
							.date(LocalDate.now())
							.student(st)
							.build();
					paymentRepository.save(payment);
				}
			});
		};
	}
}
