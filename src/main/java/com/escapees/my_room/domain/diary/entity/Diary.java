package com.escapees.my_room.domain.diary.entity;

import com.escapees.my_room.global.common.Timestamped;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "diaries")
public class Diary extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @Column(nullable = false)
    private Long userId;

    // TODO: 방 정보로 가져오게 수정
    @Column(nullable = false)
    private String roomName;

    @Column
    private String storeName;

    // TODO
    @Column
    private String withs;

    @Column
    private Double score;

    @Column
    private Double scary;

    @Column
    private String memo;

    public static Diary create(Long userId, String roomName, String storeName, String withs, Double score, Double scary, String memo) {
        return Diary.builder()
                .userId(userId)
                .roomName(roomName)
                .storeName(storeName)
                .withs(withs)
                .score(score)
                .scary(scary)
                .memo(memo)
                .build();
    }
}
