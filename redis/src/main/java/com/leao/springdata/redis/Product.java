package com.leao.springdata.redis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product implements Serializable{
    private String content;
    private String productId;
}
