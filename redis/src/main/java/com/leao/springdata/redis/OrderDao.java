package com.leao.springdata.redis;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends PagingAndSortingRepository<Order, String> {
}
