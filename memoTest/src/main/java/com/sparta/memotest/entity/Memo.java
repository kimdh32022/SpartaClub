package com.sparta.memotest.entity;

import com.sparta.memotest.dto.MemoRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoId;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 255, nullable = false)
    private String content;

    @Builder //Lombok의 @Builder는 붙은 대상 기준으로 Builder를 생성 또한 해당 빌드에 필요한 파라미터를 가지고 있는 생성자가 필요!!
    public Memo(String title, String  content) {
        this.title = title;
        this.content = content;
    }

    public static Memo newMemo(MemoRequestDto memoRequestDto){
        return Memo.builder()
                .title(memoRequestDto.getTitle())
                .content(memoRequestDto.getContent())
                .build();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
