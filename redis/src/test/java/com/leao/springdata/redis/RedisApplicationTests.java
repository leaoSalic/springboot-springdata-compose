package com.leao.springdata.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Test
    public void contextLoads() {
//        test1();
        test3();
        test2();
        test4();
        test2();

    }

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDao2 orderDao2;

    public void test1(){
        Order order = new Order();
        order.setContent("leao的redis测试");
        order.setDate(new Date());
        order.setId("123");
        order.setOrderId(UUID.randomUUID().toString());
        order.setProduct(new Product("纸尿片",UUID.randomUUID().toString()));
        orderDao.save(order);
        System.out.println("执行保存成功");
    }

    public void test2(){
        Optional<Order> byId = orderDao.findById("124");
        Order order = byId.orElse(null);
        System.out.println(order);
    }


    public void test2Delet(){
        orderDao.deleteById("123");
    }

    public void test3(){
        Order order = new Order();
        order.setContent("leao的redis测试2");
        order.setDate(new Date());
        order.setId("124");
        order.setOrderId(UUID.randomUUID().toString());
        order.setProduct(new Product("纸尿裤",UUID.randomUUID().toString()));
        orderDao2.saveorder(order);
    }

    public void test4(){
       //在dao里写死了key
        orderDao2.deleteTestById("leihao","124");
        orderDao2.findAllByName("leihao");
    }
}
