package org.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.order.domain.entity.SoHeader;

import java.util.List;
/**
 * @program: hzero-order-25126
 * @description: 订单头mapper
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
public interface SoHeaderMapper extends BaseMapper<SoHeader> {

    /**
    *@Description:根据id查询订单头
    *@Param: [id]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    SoHeader selectSoHeaderById(Long id);
    
    /**
    *@Description: 根据id获取订单状态
    *@Param: [soHeaderId]
    *@return: java.lang.String
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    String selectOrderStatusByPrimarKey(Long soHeaderId);

    /**
    *@Description: 编辑订单头
    *@Param: [soHeader]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    SoHeader updateSoHeader(SoHeader soHeader);

    /**
    *@Description: 提交流程
    *@Param: [id]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    void submitSoHeader(Long id);

    /**
    *@Description: 审批流程
    *@Param: [id]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */
    void approveSoHeader(Long id);


    /**
    *@Description: 拒绝流程
    *@Param: [id]
    *@return: org.hzero.order.domain.entity.SoHeader
    *@Author: Xingpeng.Yang
    *@date: 2019/8/7
    */

    void rejectSoHeader(Long id);

    /**
    *@Description:
    *@Param: []
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void closeSoHeader();
    
    /**
    *@Description: 创建订单头并返回ID
    *@Param: [soHeader]
    *@return: java.lang.Long
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    Long createSoHeaderWithId(SoHeader soHeader);
}
