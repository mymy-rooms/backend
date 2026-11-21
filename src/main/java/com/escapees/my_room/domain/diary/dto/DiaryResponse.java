package com.escapees.my_room.domain.diary.dto;

import com.escapees.my_room.domain.diary.entity.Diary;

public record DiaryResponse(
        Long diaryId,
        Long userId,
        String roomName,
        String storeName,
        String withs,
        Double score,
        Double scary,
        String memo
) {
    public static DiaryResponse from(Diary diary) {
        return new DiaryResponse(
                diary.getDiaryId(),
                diary.getUserId(),
                diary.getRoomName(),
                diary.getStoreName(),
                diary.getWiths(),
                diary.getScore(),
                diary.getScary(),
                diary.getMemo()
        );
    }
}
