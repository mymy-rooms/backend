package com.escapees.my_room.domain.diary.service;

import com.escapees.my_room.domain.diary.dto.DiaryCreateRequest;
import com.escapees.my_room.domain.diary.dto.DiaryResponse;
import com.escapees.my_room.domain.diary.entity.Diary;
import com.escapees.my_room.domain.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Transactional
    public DiaryResponse create(Long userId, DiaryCreateRequest request) {
        Diary diary = Diary.create(userId, request.roomName(), request.storeName(), request.withs(), request.score(), request.scary(), request.memo());
        return DiaryResponse.from(diaryRepository.save(diary));
    }
}
