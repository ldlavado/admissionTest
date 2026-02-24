package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.dto.request.MedicationRequest;
import com.sprint3.admission_test.infrastructure.dto.response.MedicationResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
@Validated
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<MedicationResponse> createMedication(@Valid @RequestBody MedicationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationUseCase.createMedication(request));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MedicationResponse>> getMedicationsByCategories(
            @PathVariable String category,
            @RequestParam(value = "expiration-after", required = true) LocalDate expirationAfter) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationsByCategories(category, expirationAfter));
    }
}
