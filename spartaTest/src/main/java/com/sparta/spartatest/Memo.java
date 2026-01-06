package com.sparta.spartatest;

import lombok.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.SQLOutput;

@Getter
@Setter
public class Memo {
    private String username;
    private  String contents;

    //    private final String contents; 잠시 지움
    ;
}