package com.sprint3.admission_test.infrastructure.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MedicationRequest(
        @NotNull(message = "the field name can not be null")
        @Size(max = 100, min = 5, message = "the length of the field description must be between 5 and 100")
        String name,

        @NotNull(message = "the field description can not be null")
        @Size(max = 255, min = 30, message = "the length of the field description must be between 30 and 255")
        @JsonProperty("description")
        String description,

        @NotNull(message = "the price description can not be null")
        BigDecimal price,

        @NotNull(message = "the expiration_date description can not be null")
        @JsonProperty("expiration_date")
        LocalDate expirationDate,

        @NotNull(message = "the category_name description can not be null")
        @Size(max = 50, min = 3, message = "the length of the field description must be between 3 and 50")
        @JsonProperty("category_name")
        String categoryName
) {
}
