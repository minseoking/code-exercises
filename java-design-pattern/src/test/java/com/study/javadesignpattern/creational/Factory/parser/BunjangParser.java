package com.study.javadesignpattern.creational.Factory.parser;

import com.study.javadesignpattern.creational.Factory.Parser;

import java.util.List;

public class BunjangParser extends Parser {

    private String url = "번개장터 수집 url";

    @Override
    public List<String> getUrls() {
        return List.of(url + "/bunjang");
    }
}
