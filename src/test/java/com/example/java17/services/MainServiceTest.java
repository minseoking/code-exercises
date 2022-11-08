package com.example.java17.services;

import com.example.java17.domains.Main;
import com.example.java17.repositories.MainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MainServiceTest {

    @Autowired
    private MainService mainService;

    @Autowired
    private MainRepository mainRepository;

    @Test
    void findMainDtoByIdTest() {
        Main main = Main.builder()
                .name("test")
                .build();
        Main savedMain = mainRepository.save(main);


        Main findMain = mainService.findMainDtoById(savedMain.getId());

        assertThat(findMain).isNotNull();
        assertThat(savedMain.getName()).isEqualTo(findMain.getName());
    }
}