package com.sparta.memotest.repository;

import com.sparta.memotest.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {

}
