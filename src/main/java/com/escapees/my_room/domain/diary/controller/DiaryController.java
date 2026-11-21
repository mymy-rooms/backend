package com.escapees.my_room.domain.diary.controller;

import com.escapees.my_room.domain.diary.dto.DiaryRequest;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/diaries")
@Tag(name = "기록")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    @Operation(summary = "작성")
    public ResponseEntity<ApiResponse<DiaryResponse>> create(
            @Valid @RequestBody DiaryRequest request
    ) {
        Long userId = 1L;
        DiaryResponse response = diaryService.create(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response));
    }

    @GetMapping
    @Operation(summary = "목록 조회")
    public ResponseEntity<ApiResponse<List<DiaryResponse>>> getDiaries() {
        Long userId = 1L;
        List<DiaryResponse> responses = diaryService.getDiaries(userId);
        return ResponseEntity.ok(ApiResponse.success(responses));
    }

    @GetMapping("/{diaryId}")
    @Operation(summary = "상세 조회")
    public ResponseEntity<ApiResponse<DiaryResponse>> getDiary(@PathVariable Long diaryId) {
        Long userId = 1L;
        DiaryResponse response = diaryService.getDiary(userId, diaryId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PutMapping("/{diaryId}")
    @Operation(summary = "수정")
    public ResponseEntity<ApiResponse<DiaryResponse>> update(@PathVariable Long diaryId,
                                                             @Valid @RequestBody DiaryRequest request) {
        Long userId = 1L;
        DiaryResponse response = diaryService.update(userId, diaryId, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{diaryId}")
    @Operation(summary = "삭제")
    public ResponseEntity<Void> delete(@PathVariable Long diaryId) {
        Long userId = 1L;
        diaryService.delete(userId, diaryId);
        return ResponseEntity.noContent().build();
    }
}
