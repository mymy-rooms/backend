package com.escapees.my_room.domain.diary.controller;

import com.escapees.my_room.domain.diary.dto.DiaryCreateRequest;
import com.escapees.my_room.domain.diary.dto.DiaryResponse;
import com.escapees.my_room.domain.diary.service.DiaryService;
import com.escapees.my_room.global.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/diaries")
@Tag(name = "기록")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    @Operation(summary = "작성")
    public ResponseEntity<ApiResponse<DiaryResponse>> create(
            @Valid @RequestBody DiaryCreateRequest request
    ) {
        Long userId = 1L;
        DiaryResponse response = diaryService.create(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response));
    }
}
