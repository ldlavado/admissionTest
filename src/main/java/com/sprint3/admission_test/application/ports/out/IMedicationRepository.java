package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Medication;

import java.util.List;
import java.util.Optional;

public interface IMedicationRepository {

    Optional<Medication> findById(Long id);

    void save(Medication medication);

    List<Medication> findAllByCategoryName(String categoryName);
}
