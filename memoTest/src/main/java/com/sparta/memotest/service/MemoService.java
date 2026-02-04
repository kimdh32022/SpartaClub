package com.sparta.memotest.service;

import com.sparta.memotest.dto.MemoRequestDto;
import com.sparta.memotest.dto.MemoResponseDto;
import com.sparta.memotest.entity.Memo;
import com.sparta.memotest.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemoService {

    private MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // 메모 등록 로직
    @Transactional
    public void createMemo(MemoRequestDto memoRequestDto) {
      Memo memo = Memo.newMemo(memoRequestDto);
      memoRepository.save(memo);
    }

    // 메모 1개 조회 로직
    @Transactional
    public MemoResponseDto selectMemo(Long id) {
       Memo memo = memoRepository.findById(id)
               .orElseThrow(()-> new IllegalArgumentException("해당 메모는 존재하지 않습니다."));

       return MemoResponseDto.from(memo);
    }

    // 메모 전체 조회 로직
    public List<MemoResponseDto> allMemo() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtolist = memos.stream().map(MemoResponseDto::from)
                .toList();

        return dtolist;
    }

    // 메모 수정 로직
    @Transactional
    public void updateMemo(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 메모가 존재하지 않습니다."));

        memo.update(
                memoRequestDto.getTitle(),
                memoRequestDto.getContent()
        );
    }

    // 메모 삭제 로직
    @Transactional
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

}
