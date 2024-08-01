package com.kamertic.gestion_etudiant_sa.repository;

import com.kamertic.gestion_etudiant_sa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    /*interface basée sur spring data donc on aura besoin d'heriter de JpaRepository.
     L'entité a gerer ici c'est Student et son id est de type string*/
    Student findByCode(String code);
    List<Student> findByProgramId(String programId);
}
