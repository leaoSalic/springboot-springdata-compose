package com.leao.springdata.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.OutputDeviceAssigned;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDao2 orderDao2;


    /**
     Repository方式
    */
    public void save(Order order){
        orderDao.save(order);
        System.out.println("保存成功");
    }

    public void findAll(Pageable pageable){
        Page<Order> orders = orderDao.findAll(pageable);
        System.out.println(orders.getTotalElements());
        Stream<Order> orderStream = orders.get();
        orders.get().forEach(x-> System.out.println(x.getContent()));
    }

    /**
     * template方式
     */
    public void save2(Order order){
        orderDao2.saveorder(order);
        System.out.println("保存成功");
    }

    public void findAll2(){
        orderDao2.findAll();
    }



}
