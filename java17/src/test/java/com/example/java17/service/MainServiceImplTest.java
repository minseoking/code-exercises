package com.example.java17.service;

import com.example.java17.api.domain.Main;
import com.example.java17.api.repository.MainRepository;
import com.example.java17.api.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MainServiceImplTest {

    @Autowired
    private MainService mainService;

    @Autowired
    private MainRepository mainRepository;

    @Test
    void findMainDtoById() {
        Main main = Main.builder()
                .name("test")
                .build();
        Main savedMain = mainRepository.save(main);


        Main findMain = mainService.findMainDtoById(savedMain.getId());

        assertThat(findMain).isNotNull();
        assertThat(savedMain.getName()).isEqualTo(findMain.getName());
    }
}