package com.example.java17.sample;

import com.example.java17.domains.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @Test
    void initListTest() {
        // c#이랑 완전 같아진듯
        var list = List.of("1", "2", "3", "4", "5");
        var cusList = new ArrayList<>(list);
        cusList.add("6");
    }

    @Test
    void linesTest() {
        var text = "제목\n내용\n태그\n";
        var texts = text.lines().toList();
    }

    @Test
    void toListTest() {
        var one = Main.builder()
                .name("one")
                .build();
        var two = Main.builder()
                .name("two")
                .build();

        var mains = List.of(one, two);
        var names = mains.stream().map(Main::getName).toList();
    }

    @Test
    void nullTest() {
        Main main = null;

        try {
            main.getId();
        }catch (Exception e){
            // 어떤 변수에서 null 인지 확인
            System.out.println(e);
        }
    }
}
