package com.study.springtest.tests;

import com.study.springtest.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {

    @Test
    @DisplayName("메뉴 변경 테스트")
    void changeMenuTest() {
        Menu menu = new Menu("국밥");
        menu.changeMenu("냉면");

        assertThat(menu.getName()).isEqualTo("냉면");
    }

    @Test
    @DisplayName("주문 테스트")
    void orderTest() {
        Menu menu1 = new Menu("국밥");
        Menu menu2 = new Menu("냉면");

        Order order = new Order(List.of(menu1, menu2));

        order.addMenu(new Menu("돈까스"));

        assertThat(order.getMenus().size()).isEqualTo(3);
    }

    private class Order {
        private List<Menu> menus = new ArrayList<>();

        public List<Menu> getMenus() {
            return menus;
        }

        public void addMenu(Menu menu) {
            menus.add(menu);
        }
        public Order(List<Menu> menus) {
            this.menus.addAll(menus);
        }
    }
}

