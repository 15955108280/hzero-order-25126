package org.hzero.order.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.order.domain.entity.Customer;
import org.springframework.stereotype.Repository;
/**
 * @program: hzero-order-25126
 * @description: 顾客Repository
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Repository
public interface CustomerRepository extends BaseRepository<Customer> {
}
