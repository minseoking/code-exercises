package com.example.java17.api.service;

import com.example.java17.api.domain.Main;
import com.example.java17.api.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{

    private final MainRepository mainRepository;

    @Override
    public Main findMainDtoById(Long mainId) {

        return mainRepository.findById(mainId).orElse(null);
    }
}
