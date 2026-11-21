package com.escapees.my_room.domain.diary.service;

import com.escapees.my_room.domain.diary.dto.DiaryRequest;
import com.escapees.my_room.domain.diary.dto.DiaryResponse;
import com.escapees.my_room.domain.diary.entity.Diary;
import com.escapees.my_room.domain.diary.repository.DiaryRepository;
import com.escapees.my_room.global.exception.BusinessException;
import com.escapees.my_room.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Transactional
    public DiaryResponse create(Long userId, DiaryRequest request) {
        Diary diary = Diary.create(userId, request.roomName(), request.storeName(), request.withs(), request.score(), request.scary(), request.memo());
        return DiaryResponse.from(diaryRepository.save(diary));
    }

    public List<DiaryResponse> getDiaries(Long userId) {
        List<Diary> diaries = diaryRepository.findByUserIdAndDeletedAtIsNull(userId);
        return diaries.stream().map(DiaryResponse::from).toList();
    }

    public DiaryResponse getDiary(Long userId, Long diaryId) {
        Diary diary = findDiary(userId, diaryId);
        return DiaryResponse.from(diary);
    }

    @Transactional
    public DiaryResponse update(Long userId, Long diaryId, DiaryRequest request) {
        Diary diary = findDiary(userId, diaryId);
        diary.update(request.roomName(), request.storeName(), request.withs(), request.score(), request.scary(), request.memo());
        return DiaryResponse.from(diary);
    }

    @Transactional
    public void delete(Long userId, Long diaryId) {
        Diary diary = findDiary(userId, diaryId);
        diary.markDeleted(userId);
    }

    private Diary findDiary(Long userId, Long diaryId) {
        return diaryRepository.findBByUserIdAndDiaryIdAndDeletedAtIsNull(userId, diaryId)
                .orElseThrow(() -> new BusinessException(ErrorCode.DIARY_NOT_FOUND));
    }
}
