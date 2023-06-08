package com.example.java17.repository;

import com.example.java17.api.domain.Main;
import com.example.java17.api.repository.MainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MainRepositoryTest {

    @Autowired
    private MainRepository mainRepository;

    @Test
    void findByIdTest(){
        Main main = Main.builder()
                .name("테스트")
                .build();
        Main savedMain = mainRepository.save(main);

        assertThat(savedMain).isNotNull();
        assertThat(main.getName()).isEqualTo(main.getName());
    }
}