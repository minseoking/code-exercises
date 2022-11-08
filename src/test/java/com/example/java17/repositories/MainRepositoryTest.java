package com.example.java17.repositories;

import com.example.java17.domains.Main;
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