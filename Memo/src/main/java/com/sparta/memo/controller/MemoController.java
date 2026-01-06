package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memolist = new HashMap<>();

    //등록하는 API 만일 메모가 없다면 1번으로 삼항연산자로 등록
    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        //RequestDto를 Entity로 변환
        Memo memo = new Memo(requestDto);

        //Memo의 Max id를 찾기
        Long maxid = memolist.size() > 0 ? Collections.max(memolist.keySet()) + 1 : 1;
        memo.setId(maxid);

        //Database저장
        memolist.put(memo.getId(), memo);

        //Entity -> ResponseDto로 변환
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    // 조회하는 API
    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        //Map to List
        List<MemoResponseDto> responseList = memolist.values().stream().map(MemoResponseDto::new).toList();
        return responseList;
    }

    @PutMapping("/memos/{id}")
    public Long updateMomo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        if (memolist.containsKey(id)) {
            Memo memo = memolist.get(id);

            //가져온 메모 수정
            memo.update(requestDto);
            return memo.getId();
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMomo(@PathVariable Long id) {
        //해당 메모가 DB에 존재하는지 확인
        if (memolist.containsKey(id)) {
            memolist.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}
