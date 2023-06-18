package com.study.javadesignpattern.creational.Factory.parser;

import com.study.javadesignpattern.creational.Factory.Parser;

import java.util.List;

public class JoongnaParser extends Parser {

    private String url = "중고나라 수집 url";

    @Override
    public List<String> getUrls() {
        return List.of(url + "/joongna");
    }
}
