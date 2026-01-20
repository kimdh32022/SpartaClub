package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Folder;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);
    // select * from folder;  전체 조회
    // select * from folder where user_id = ? and name in(?, ?, ?) where user_id가 ? 인데 폴더 이름이 (?, ?, ?)인것들

    List<Folder> findAllByUser(User user);
}
