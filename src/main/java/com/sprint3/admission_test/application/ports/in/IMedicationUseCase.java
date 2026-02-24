package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.dto.request.MedicationRequest;
import com.sprint3.admission_test.infrastructure.dto.response.MedicationResponse;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {

    Medication getMedicationById(Long id);

    MedicationResponse createMedication(MedicationRequest medicationRequest);

    List<MedicationResponse> getMedicationsByCategories(String categoryName, LocalDate expirationDate);
}
