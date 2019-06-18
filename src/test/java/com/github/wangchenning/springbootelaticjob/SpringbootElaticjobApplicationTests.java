package com.github.wangchenning.springbootelaticjob;

import com.github.wangchenning.springbootelaticjob.model.Order;
import com.github.wangchenning.springbootelaticjob.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElaticjobApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 50; i++) {
            orderService.insertOrder();
        }
    }

    @Test
    public void test1() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.SECOND,-30);
        List<Order> order = orderService.getOrder(now, 2, 1);
        System.out.println(order.stream().map(Order::getId).collect(Collectors.toList()));
    }
}
