package org.hzero.order.app.service;

import org.hzero.order.api.dto.OrderDTO;

/**
 * @program: hzero-order-25126
 * @description: 订单服务
 * @author: Xingpeng.Yang
 * @create: 2019-08-07 18:46
 */
public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);
}
