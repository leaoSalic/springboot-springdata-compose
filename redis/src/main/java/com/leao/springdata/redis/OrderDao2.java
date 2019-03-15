package com.leao.springdata.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public class OrderDao2 {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 创建对象
     */
    public void saveorder(Order order) {


        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("leihao",order.getId(),order);
    }


    /**
     * 根据用户名查询对象
     * @return
     */
    public Order findTestByName(String name,String id) {
        HashOperations<String, String, Order> hashOperations= redisTemplate.opsForHash();
        Order order = (Order)hashOperations.get(name, id);
        return order;
    }

    /**
     * 更新对象
     */
    public void updateTest(String name,String id,Order order) {
        redisTemplate.opsForHash().put(name,id,order);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteTestById(String name,Integer id) {
        redisTemplate.opsForHash().delete(name,id);
    }

    public void findAllByName(String name) {
        Set keys = redisTemplate.opsForHash().keys(name);
        System.out.println(keys);
    }
}
