package com.leao.springdata.mongodb;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends PagingAndSortingRepository<Order, String> {
}
