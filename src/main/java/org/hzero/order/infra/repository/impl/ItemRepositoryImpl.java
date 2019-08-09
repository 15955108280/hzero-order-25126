package org.hzero.order.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.order.domain.entity.Company;
import org.hzero.order.domain.entity.Item;
import org.hzero.order.domain.repository.CompanyRepository;
import org.hzero.order.domain.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {
}
