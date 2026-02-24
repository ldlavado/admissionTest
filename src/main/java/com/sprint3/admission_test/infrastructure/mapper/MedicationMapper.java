package com.sprint3.admission_test.infrastructure.mapper;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.dto.request.MedicationRequest;
import com.sprint3.admission_test.infrastructure.dto.response.CategoryResponse;
import com.sprint3.admission_test.infrastructure.dto.response.MedicationResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class MedicationMapper {

    public Medication toMedication(MedicationRequest request, Category category) {
        return Medication.builder()
                .price(request.price())
                .name(request.name())
                .description(request.description())
                .expirationDate(request.expirationDate())
                .category(category)
                .build();
    }

    public MedicationResponse toMedicationResponse(Medication medication) {
        Map<String, Object> categoryMap = new LinkedHashMap<>();
        categoryMap.put("id", medication.getCategory().getId());
        categoryMap.put("name", medication.getName());

        CategoryResponse categoryResponse = new CategoryResponse(medication.getCategory().getId(), medication.getCategory().getName());

        return new MedicationResponse(
                medication.getName(),
                medication.getDescription(),
                medication.getPrice(),
                medication.getExpirationDate(),
                medication.getCategory().getName(),
                categoryResponse);
    }

    public List<MedicationResponse> toMedicationsResponse(List<Medication> medications, LocalDate afterDate) {
        List<MedicationResponse> medicationResponses = new LinkedList<>();

        medications.forEach(medication -> {

            if (medication.getExpirationDate().isAfter(afterDate)) {
                Map<String, Object> categoryMap = new LinkedHashMap<>();
                categoryMap.put("id", medication.getCategory().getId());
                categoryMap.put("name", medication.getName());

                CategoryResponse categoryResponse = new CategoryResponse(medication.getCategory().getId(), medication.getCategory().getName());

                medicationResponses.add(new MedicationResponse(medication.getName(),
                        medication.getDescription(),
                        medication.getPrice(),
                        medication.getExpirationDate(),
                        medication.getCategory().getName(),
                        categoryResponse));
            }
        });
        return medicationResponses;
    }
}
