package com.example.demo.service;

import com.example.demo.model.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public void setPrescriptionRepository(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getPrescriptions() {
        List<Prescription> prescriptionList = prescriptionRepository.findAll();
        return prescriptionList;
    }

    public Prescription getPrescription(Long prescriptionId) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(prescriptionId);
        return optionalPrescription.get();
    }

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void deletePrescription(Long prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);
    }

    public List<LocalTime> getAdministrations(Long prescriptionId) {
        Prescription prescription = this.getPrescription(prescriptionId);
        List<LocalTime> administartionTimes = new ArrayList<>();
        for (Timestamp currTime = prescription.getStart_time();
             currTime.before(prescription.getEnd_time());
             //Add multiply with 3600000 to get miliseconds from hour period
             currTime.setTime(currTime.getTime() + (long) (prescription.getTiming_hours_period() * 3600000))) {
            administartionTimes.add(currTime.toLocalDateTime().toLocalTime());
        }
        return administartionTimes;
    }

}
