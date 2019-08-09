package org.hzero.order.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.domain.entity.SoHeader;
import org.springframework.stereotype.Repository;
/**
 * @program: hzero-order-25126
 * @description: 订单头Repository
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Repository
public interface SoHeaderRepository extends BaseRepository<SoHeader> {
    Page<SoHeader> pageSoHeader(SoHeader soHeader, PageRequest pageRequest);
   /**
   *@Description:创建订单头
   *@Param: [soHeader]
   *@return: void
   *@Author: Xingpeng.Yang
   *@date: 2019/8/7
   */
    void createSoHeader(SoHeader soHeader);
    /**
    *@Description: 根据主键查询订单状态
    *@Param: [soHeaderId]
    *@return: java.lang.String
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    String selectOrderStatusByPrimarKey(Long soHeaderId);
    /**
    *@Description: 编辑订单
    *@Param: [soHeader]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    SoHeader updateHeader(SoHeader soHeader);

    /**
    *@Description:提交
    *@Param: [id]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    OrderDTO submitSoHeader(Long id);

    /**
    *@Description: 审批订单
    *@Param: [id]
    *@return: org.hzero.order.api.dto.OrderDTO
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    OrderDTO approveSoHeader(Long id);

    /**
    *@Description: 拒绝订单
    *@Param: [id]
    *@return: org.hzero.order.api.dto.OrderDTO
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    OrderDTO rejectSoHeader(Long id);

    /**
    *@Description: 关闭订单
    *@Param: []
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void closeSoHeader();

    /**
    *@Description:创建订单头返回ID
    *@Param: [soHeader]
    *@return: java.lang.Long
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    Long createSoHeaderWithId(SoHeader soHeader);
}
