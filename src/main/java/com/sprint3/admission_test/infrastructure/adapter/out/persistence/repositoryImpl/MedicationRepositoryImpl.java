package com.sprint3.admission_test.infrastructure.adapter.out.persistence.repositoryImpl;

import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MedicationRepositoryImpl implements IMedicationRepository {

    private final MedicationJpaRepository medicationJpaRepository;

    @Override
    public Optional<Medication> findById(Long id) {
        return medicationJpaRepository.findById(id);
    }

    @Override
    public void save(Medication medication) {
        medicationJpaRepository.save(medication);
    }

    @Override
    public List<Medication> findAllByCategoryName(String categoryName) {
        return medicationJpaRepository.findAllByCategoryName(categoryName);
    }
}
