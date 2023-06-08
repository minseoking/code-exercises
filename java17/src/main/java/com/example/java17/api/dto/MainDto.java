package com.example.java17.api.dto;

import com.example.java17.api.domain.Main;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainDto {

    private Long id;
    private String name;

    public static MainDto of(Main main){
        return MainDto.builder()
                .id(main.getId())
                .name(main.getName())
                .build();
    }
}
