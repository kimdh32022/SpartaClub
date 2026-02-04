package com.sparta.memotest.controller;

import com.sparta.memotest.dto.MemoRequestDto;
import com.sparta.memotest.dto.MemoResponseDto;
import com.sparta.memotest.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    // 메모 등록
    @PostMapping("/memo")
    public void createMemo(@RequestBody MemoRequestDto memoRequestDto){
        memoService.createMemo(memoRequestDto);
    }

    //메모 하나 조회
    @GetMapping("/memo/{id}")
    public MemoResponseDto readMemo(@PathVariable Long id){
        return memoService.selectMemo(id);
    }

    //메모 전체 조회
    @GetMapping("/memos")
    public List<MemoResponseDto> readAllMemos(){
        return memoService.allMemo();
    }

    // 메모 수정
    @PutMapping("/memo/{id}")
    public void updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto){
        memoService.updateMemo(id,memoRequestDto);
    }

    // 메모 삭제
    @DeleteMapping("/memo/{id}")
    public void deleteMemo(@PathVariable Long id){
        memoService.deleteMemo(id);
    }
}
