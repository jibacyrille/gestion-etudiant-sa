package com.kamertic.gestion_etudiant_sa.services;

import com.kamertic.gestion_etudiant_sa.dtos.PaymentDTO;
import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import com.kamertic.gestion_etudiant_sa.entities.Payment;
import com.kamertic.gestion_etudiant_sa.entities.PaymentStatus;
import com.kamertic.gestion_etudiant_sa.repository.PaymentRepository;
import com.kamertic.gestion_etudiant_sa.repository.EleveRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class PaymentService {
    private EleveRepository eleveRepository;
    private PaymentRepository paymentRepository;

  /*  public PaymentService(EleveRepository eleveRepository, PaymentRepository paymentRepository) {
        this.eleveRepository = eleveRepository;
        this.paymentRepository = paymentRepository;
    }

    @PostMapping(path="/payments", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(MultipartFile file, PaymentDTO newPaymentDTO) throws IOException {
        Path folderPath= Paths.get(System.getProperty("user.home"), "kamertic-data", "payments");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName= UUID.randomUUID().toString();
        Path filePath= Paths.get(System.getProperty("user.home"), "kamertic-data", "payments", fileName+".pdf");
        Files.copy(file.getInputStream(), filePath);
        Eleve eleve = eleveRepository.findByCode(newPaymentDTO.getStudentCode());
        Payment payment=Payment.builder()
                .date(newPaymentDTO.getDate())
                .type(newPaymentDTO.getType())
                .amount(newPaymentDTO.getAmount())
                .status(PaymentStatus.CREATED)
                .file(filePath.toUri().toString())
                .eleve(eleve)
                .build();
        return paymentRepository.save(payment);
    }

    public Payment updatePaymentStatus(PaymentStatus status, Long id){
        Payment payment=paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public byte[] getPaymentFile(Long paymentId) throws IOException {
        Payment payment=paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }*/
}
