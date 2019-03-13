package com.leao.springdata.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private String orderId;
    private String content;
    private Date date;

}
