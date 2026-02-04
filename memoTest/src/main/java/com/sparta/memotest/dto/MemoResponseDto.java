package com.sparta.memotest.dto;

import com.sparta.memotest.entity.Memo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // GPT 도움 받음 Lombok의 @Builder는 붙은 대상 기준으로 Builder를 생성
public class MemoResponseDto {
    private Long id;
    private String title;
    private String content;

    public static MemoResponseDto from(Memo memo) {
        MemoResponseDto memoDto = MemoResponseDto.builder()
                .id(memo.getMemoId())
                .title(memo.getTitle())
                .content(memo.getContent())
                .build();
        return memoDto;
    }
}
