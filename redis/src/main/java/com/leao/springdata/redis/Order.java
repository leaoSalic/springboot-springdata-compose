package com.leao.springdata.redis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

@Data
@RedisHash
public class Order implements Serializable {
//    @Id
//    @Indexed
    private String id;
    private String orderId;
    private String content;
    private Date date;
    private Product product;

}
