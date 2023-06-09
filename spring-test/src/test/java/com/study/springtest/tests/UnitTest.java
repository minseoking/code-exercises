package com.study.springtest.tests;

import com.study.springtest.Menu;
import com.study.springtest.Order;
import com.study.springtest.OrderRepository;
import com.study.springtest.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UnitTest {

    @MockBean
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

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

    @Test
    @DisplayName("주문 서비스의 단위 테스트")
    void orderServiceTest(){
        // given
        Order order = new Order();
        order.setId(1L);
        given(orderRepository.findById(anyLong())).willReturn(order);

        // when
        Order saveOrder = orderService.getOrderById(anyLong());

        // then
        assertThat(order.getId()).isEqualTo(saveOrder.getId());
    }

}

