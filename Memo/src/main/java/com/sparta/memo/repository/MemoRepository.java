package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByOrderByModifiedAtDesc();
    //ModifiedAt이라는 필드 테이블을 기준으로 Desc(내림차순)으로 정렬해서 전체 데이터를 보내라.
    //이런 이름으로 Method를 선언하면 사용할수 있음.\
//    List<Memo> findAllByUsername(String username);
// 이 메서드를 호출할때 파라미터의 유저네임을 가지고 있는 모든 메모를 찾아 준다. (where 조건문에 username이 들어감)
}
