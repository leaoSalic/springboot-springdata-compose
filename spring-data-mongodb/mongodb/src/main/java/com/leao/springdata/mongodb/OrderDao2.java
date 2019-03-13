package com.leao.springdata.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao2 {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     */
    public void saveorder(Order order) {
        mongoTemplate.save(order);
    }


    /**
     * 根据用户名查询对象
     * @return
     */
    public Order findTestByName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        Order order =  mongoTemplate.findOne(query , Order.class);
        return order;
    }

    /**
     * 更新对象
     */
    public void updateTest(Order order) {
        Query query=new Query(Criteria.where("id").is(order.getId()));
        Update update= new Update().set("content", order.getContent()).set("date", order.getDate());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,Order.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteTestById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Order.class);
    }

    public void findAll() {
        List<Order> all = mongoTemplate.findAll(Order.class,"order");
        System.out.println(all);
    }
}
