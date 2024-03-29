package com.example.java17.api.controller;

import com.example.java17.api.service.MainService;
import com.example.java17.api.dto.MainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/{main_id}")
    @ResponseStatus(HttpStatus.OK)
    public MainDto getMainById(@PathVariable("main_id") Long mainId){

        return MainDto.of(mainService.findMainDtoById(mainId));
    }

}
