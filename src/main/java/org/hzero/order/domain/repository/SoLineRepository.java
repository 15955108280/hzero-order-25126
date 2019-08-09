package org.hzero.order.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.order.domain.entity.SoLine;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @program: hzero-order-25126
 * @description: 订单行Repository
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Repository
public interface SoLineRepository extends BaseRepository<SoLine> {
    /**
    *@Description: 根据id查询行信息
    *@Param: [id]
    *@return: java.util.List<org.hzero.order.domain.entity.SoLine>
    *@Author: Xingpeng.Yang
    *@date: 2019/8/6
    */
    List<SoLine> querySoLine(Long id);

    /**
    *@Description: 创建行信息
    *@Param: [soLine]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/6
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
    *@Description: 根据订单头获取订单行最大行号
    *@Param: [id]
    *@return: java.lang.Integer
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    Integer selectMaxLineNumber(Long id);

    /**
    *@Description: 更新订单行
    *@Param: [soLine]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void updateSoLine(SoLine soLine);

    /**
    *@Description: 创建订单行链表
    *@Param: [soLineList]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void createSoLineList(List<SoLine> soLineList);

    /**
    *@Description: 根据ID删除订单行
    *@Param: [id]
    *@return: void
    *@Author: Xingpeng.Yang
    *@date: 2019/8/8
    */
    void deleteByHeaderId(Long id);
}
