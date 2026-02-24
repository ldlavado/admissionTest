package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.dto.request.MedicationRequest;
import com.sprint3.admission_test.infrastructure.dto.response.MedicationResponse;
import com.sprint3.admission_test.infrastructure.mapper.MedicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationUseCaseImpl implements IMedicationUseCase {

    private final IMedicationRepository medicationRepository;
    private final ICategoryRepository categoryRepository;
    private final MedicationMapper medicationMapper;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public MedicationResponse createMedication(MedicationRequest medicationRequest) {
        Category category = categoryRepository.findByName(medicationRequest.categoryName()).orElseThrow(() -> new NotFoundException("Could not find the category: " + medicationRequest.categoryName()));
        Medication medication = medicationMapper.toMedication(medicationRequest, category);
        medicationRepository.save(medication);

        return medicationMapper.toMedicationResponse(medication);
    }

    @Override
    public List<MedicationResponse> getMedicationsByCategories(String categoryName, LocalDate expirationDate) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow(() -> new NotFoundException("Could not find the category: " + categoryName));

        return medicationMapper.toMedicationsResponse(medicationRepository.findAllByCategoryName(categoryName), expirationDate);
    }
}
