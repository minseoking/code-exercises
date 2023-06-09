package com.study.springtest;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private List<Menu> menus = new ArrayList<>();

    public Order() {
    }

    public Order(List<Menu> menus) {
        this.menus.addAll(menus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Menu> getMenus() {
        return menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

}
