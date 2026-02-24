package com.sprint3.admission_test.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MedicationResponse(

        @NotNull
        @Size(max = 100, min = 5)
        String name,

        @NotNull
        @Size(max = 255, min = 30)
        @JsonProperty("description")
        String description,

        @NotNull
        BigDecimal price,

        @NotNull
        @JsonProperty("expiration_date")
        LocalDate expirationDate,

        @NotNull
        @Size(max = 50, min = 3)
        @JsonProperty("category_name")
        String categoryName,

        @JsonProperty("category")
        CategoryResponse category
) {
}
