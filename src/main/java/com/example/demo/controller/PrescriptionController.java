package com.example.demo.controller;

import com.example.demo.model.Prescription;
import com.example.demo.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    public void setPrescriptionService(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }


    @GetMapping("/api/prescriptions")
    public List<Prescription> getPrescriptions() {
        List<Prescription> prescriptionList = prescriptionService.getPrescriptions();
        return prescriptionList;
    }

    @GetMapping("/api/prescriptions/{prescriptionId}")
    public Prescription getPrescription(@PathVariable(name = "prescriptionId") Long prescriptionId) {
        return prescriptionService.getPrescription(prescriptionId);
    }

    @GetMapping("/api/prescriptions/{prescriptionId}/administrations")
    public List<LocalTime> getPrescriptions(@PathVariable(name = "prescriptionId") Long prescriptionId) {
        return this.prescriptionService.getAdministrations(prescriptionId);
    }


    @PostMapping("api/prescriptions")
    public Prescription savePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(prescription);
    }

    @PutMapping("api/prescriptions/{prescriptionId}")
    public Prescription updatePrescription(@RequestBody Prescription prescription,
                                           @PathVariable(name = "prescriptionId") Long prescriptionId) {
        Prescription storedPrescription = prescriptionService.getPrescription(prescriptionId);
        prescription.setId(prescriptionId);
        if (storedPrescription != null) {
            return prescriptionService.savePrescription(prescription);
        } else {
            return null;
        }
    }

    @DeleteMapping("api/prescriptions/{prescriptionId}")
    public void deletePrescription(@PathVariable(name = "prescriptionId") Long prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
    }
}
