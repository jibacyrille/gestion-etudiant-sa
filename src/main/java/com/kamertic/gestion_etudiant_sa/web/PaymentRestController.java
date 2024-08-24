package com.kamertic.gestion_etudiant_sa.web;

import com.kamertic.gestion_etudiant_sa.dtos.PaymentDTO;
import com.kamertic.gestion_etudiant_sa.entities.Eleve;
import com.kamertic.gestion_etudiant_sa.entities.Payment;
import com.kamertic.gestion_etudiant_sa.entities.PaymentStatus;
import com.kamertic.gestion_etudiant_sa.entities.PaymentType;
import com.kamertic.gestion_etudiant_sa.repository.PaymentRepository;
import com.kamertic.gestion_etudiant_sa.repository.EleveRepository;
import com.kamertic.gestion_etudiant_sa.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PaymentRestController {
    private EleveRepository eleveRepository;
    private PaymentRepository paymentRepository;
    private PaymentService paymentService;
    public PaymentRestController(PaymentRepository paymentRepository, EleveRepository eleveRepository,
                                 PaymentService paymentService){
        this.paymentRepository=paymentRepository;
        this.eleveRepository = eleveRepository;
        this.paymentService=paymentService;
    }
/*
    @GetMapping(path="/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }
    @GetMapping(path="/students/{code}/payments")
    public List<Payment> paymentsByStudents(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path="/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }

    @GetMapping(path="/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path="/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
    @GetMapping(path="/students")
    public List<Eleve> allStudents(){
        return eleveRepository.findAll();
    }
    @GetMapping(path="/students/{code}")
    public Eleve getStudentByCode(@PathVariable String code){
        return eleveRepository.findByCode(code);
    }

    @DeleteMapping(path = "delete/payments/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
    }


    @GetMapping(path="/studentsByProgramId")
    public List<Eleve> getStudentsByProgramId(@RequestParam String programId){
        return eleveRepository.findByProgramId(programId);
    }

    @PutMapping(path="/payments/{id}")
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id){

        return this.paymentService.updatePaymentStatus(status, id);
    }

    @PostMapping(path="/payments", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam("file") MultipartFile file, PaymentDTO newPaymentDTO) throws IOException {
        return this.paymentService.savePayment(file, newPaymentDTO);
    }

    @GetMapping(path="/paymentFile/{paymentId}", produces=MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long paymentId) throws IOException {
        return this.paymentService.getPaymentFile(paymentId);
    }*/

}
