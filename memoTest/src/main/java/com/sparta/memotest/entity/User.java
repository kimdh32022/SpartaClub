package com.sparta.memotest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userid;

    // 아이디
    @Column(nullable = false, unique = true)
    private String idname;

    //비밀번호
    @Column(nullable = false)
    private String password;

    // 이메일
    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Memo memo;



}
