package org.hzero.order.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.api.dto.OrderSummaryDTO;
import org.hzero.order.domain.entity.SoHeader;
import org.springframework.stereotype.Repository;

/**
 * @program: hzero-order-25126
 * @description: 订单查询接口
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 15:44
 */
@Repository
public interface OrderRepository  {
    /**
    *@Description: 分页查询订单
    *@Param: [soHeader, pageRequest]
    *@return: io.choerodon.core.domain.Page<org.hzero.order.api.dto.OrderDTO>
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    Page<OrderSummaryDTO> pageOrder(SoHeader soHeader, PageRequest pageRequest);

    /**
    *@Description: 按id查询订单
    *@Param: [id]
    *@return: org.hzero.order.api.dto.OrderDTO
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    OrderDTO selectOrderById(Long id);

}
