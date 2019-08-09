package org.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.hzero.order.domain.entity.SoLine;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.List;
/**
 * @program: hzero-order-25126
 * @description: 订单行mapper
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
public interface SoLineMapper extends BaseMapper<SoLine> {
    /**
    *@Description: 根据ID查询订单行
    *@Param: [id]
    *@return: java.util.List<org.hzero.order.domain.entity.SoLine>
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    List<SoLine> querySoLine(Long id);

    /**
    *@Description: 单独创建订单行
    *@Param: [soLine]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void createSoLine(SoLine soLine);

    /**
    *@Description: 根据订单头查询订单行
    *@Param: [id]
    *@return: java.util.List<org.hzero.order.domain.entity.SoLine>
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    List<SoLine> selectByHeaderId(Long id);

    /**
    *@Description: 根据订单头查询最大行号
    *@Param: [id]
    *@return: java.lang.Integer
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    Integer selectMaxLineNumber(Long id);

    /**
    *@Description: 单独更新一条订单行
    *@Param: [soLine]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void updateSoLine(SoLine soLine);

    /**
    *@Description: 跟新订单行链表
    *@Param: [soLineList]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void createSoLineList(@Param(value ="soLineList") List<SoLine> soLineList);

    /**
    *@Description: 根据订单头删除所有订单行
    *@Param: [id]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void deleteByHeaderId(Long id);
}
