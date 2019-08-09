package org.hzero.order.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.api.dto.OrderSummaryDTO;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.domain.repository.OrderRepository;
import org.hzero.order.infra.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: hzero-order-25126
 * @description: 订单查询
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 15:46
 */
@Component
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Page<OrderSummaryDTO> pageOrder(SoHeader soHeader, PageRequest pageRequest) {
        return  PageHelper.doPage(pageRequest, () -> orderMapper.selectOrder(soHeader));
    }
    @Override
    public OrderDTO selectOrderById(Long id) {
        return orderMapper.selectOrderById(id);
    }
}
