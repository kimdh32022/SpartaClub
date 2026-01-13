package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {
//    1번 해결방법
//    @Autowired
//    Food pizza;
//
//    @Autowired
//    Food chicken;
// primary가 적용되면 같은 타입의 Bean중 우선 주입함.
    @Autowired
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("테스트")
    void test1(){
//        pizza.eat();
//        chicken.eat();
        food.eat();
    }
        // primary 와 Qualifier 중 누가 더 우선 순위가 높냐?
        //  좁은 범위에 적용되는 기술인 Qualifier이 우선 순위가 높다.
}
