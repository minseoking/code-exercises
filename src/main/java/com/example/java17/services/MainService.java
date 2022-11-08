package com.example.java17.services;

import com.example.java17.domains.Main;
import com.example.java17.dto.MainDto;

public interface MainService {

    Main findMainDtoById(Long mainId);
}
