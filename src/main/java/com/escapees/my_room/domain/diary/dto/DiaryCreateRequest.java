package com.escapees.my_room.domain.diary.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record DiaryCreateRequest(
        @NotBlank String roomName,
        String storeName,
        String withs,
        @DecimalMin("0.0") @DecimalMax("5.0") Double score,
        @DecimalMin("0.0") @DecimalMax("5.0") Double scary,
        String memo
) {
}
