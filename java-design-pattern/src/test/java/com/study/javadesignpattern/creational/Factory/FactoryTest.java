package com.study.javadesignpattern.creational.Factory;

import com.study.javadesignpattern.creational.Factory.parser.BunjangParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FactoryTest {

    @Test
    public void factoryTest() {
        Parser parser = SimpleParserFactory.getParser("BUNJANG");
        List<String> urls = parser.getUrls();

        assertThat(urls.size()).isEqualTo(1);
        assertThat(urls.get(0)).isEqualTo("번개장터 수집 url/bunjang");
    }
}
