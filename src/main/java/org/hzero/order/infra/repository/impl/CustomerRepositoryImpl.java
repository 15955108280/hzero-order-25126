package org.hzero.order.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.order.domain.entity.Company;
import org.hzero.order.domain.entity.Customer;
import org.hzero.order.domain.repository.CompanyRepository;
import org.hzero.order.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {
}
