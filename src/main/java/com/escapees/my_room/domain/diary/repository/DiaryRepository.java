package com.escapees.my_room.domain.diary.repository;

import com.escapees.my_room.domain.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
