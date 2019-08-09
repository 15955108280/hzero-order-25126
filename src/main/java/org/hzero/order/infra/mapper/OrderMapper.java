package org.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.api.dto.OrderSummaryDTO;
import org.hzero.order.domain.entity.SoHeader;

import java.util.List;

/**
 * @program: hzero-order-25126
 * @description: 订单Mapper
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 15:47
 */
public interface OrderMapper  {
    List<OrderSummaryDTO> selectOrder(SoHeader soHeader);
    OrderDTO selectOrderById(Long id);
}
