package com.example.java17.services;

import com.example.java17.domains.Main;
import com.example.java17.repositories.MainRepository;
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
