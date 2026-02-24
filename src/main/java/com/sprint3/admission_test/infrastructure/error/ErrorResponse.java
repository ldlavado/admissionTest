package com.sprint3.admission_test.infrastructure.error;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime time_stamp,
        String message
) {
}
