package com.sparta.memotest.service;

import com.sparta.memotest.dto.MemoRequestDto;
import com.sparta.memotest.dto.MemoResponseDto;
import com.sparta.memotest.entity.Memo;
import com.sparta.memotest.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {
    private MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // 메모 등록 로직
    public void createMemo(MemoRequestDto memoRequestDto) {
      Memo memo = Memo.newMemo(memoRequestDto);
      memoRepository.save(memo);
    }

    // 메모 1개 조회 로직
    public MemoResponseDto selectMemo(Long id) {
       Memo memo = memoRepository.findById(id)
               .orElseThrow(()-> new IllegalArgumentException("해당 메모는 존재하지 않습니다."));

       return MemoResponseDto.from(memo);
    }

    public List<MemoResponseDto> allMemo() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtolist = memos.stream().map(MemoResponseDto::from)
                .toList();

        return dtolist;
    }
}
