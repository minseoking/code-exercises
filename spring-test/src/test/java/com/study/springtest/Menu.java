package com.study.springtest;

public class Menu {
    private String name;

    public String getName() {
        return name;
    }

    public Menu(String name) {
        this.name = name;
    }

    public void changeMenu(String name) {
        this.name = name;
    }
}
