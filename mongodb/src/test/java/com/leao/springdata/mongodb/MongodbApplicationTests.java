package com.leao.springdata.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {


    @Test
    public void contextLoads() {
        test2();
        test3();
    }




    @Autowired
    private OrderServiceImpl orderService;
    private void test1(){
        orderService.findAll(PageRequest.of(0,10, Sort.by("id")));
    }

    private void test2() {
        Order order = new Order();
        order.setContent("springdata");order.setDate(new Date());
//        order.setId("123456");
        order.setOrderId(UUID.randomUUID().toString());
        orderService.save(order);
    }

    private void test3(){
        orderService.findAll2();
    }

}
