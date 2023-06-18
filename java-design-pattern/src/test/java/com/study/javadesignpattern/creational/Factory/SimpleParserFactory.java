package com.study.javadesignpattern.creational.Factory;

import com.study.javadesignpattern.creational.Factory.parser.BunjangParser;
import com.study.javadesignpattern.creational.Factory.parser.JoongnaParser;

public class SimpleParserFactory {
    public static Parser getParser(String parserType) {
        switch (parserType){
            case "BUNJANG": return new BunjangParser();
            case "JOONGNA": return new JoongnaParser();
            default: throw new IllegalArgumentException("No such parser " + parserType);
        }
    }
}
