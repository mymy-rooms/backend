package com.escapees.my_room.domain.diary.repository;

import com.escapees.my_room.domain.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByUserIdAndDeletedAtIsNull(Long userId);

    Optional<Diary> findBByUserIdAndDiaryIdAndDeletedAtIsNull(Long userId, Long diaryId);
}
