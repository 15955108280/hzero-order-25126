package org.hzero.order.app.service.impl;

import io.choerodon.core.exception.CommonException;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.app.service.SoLineService;
import org.hzero.order.domain.entity.OrderStatus;
import org.hzero.order.domain.entity.SoLine;
import org.hzero.order.domain.repository.OrderRepository;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.hzero.order.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @program: hzero-order-25126
 * @description: 订单行服务实现
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Service
public class SoLineServiceImpl implements SoLineService {
    @Autowired
    SoLineRepository soLineRepository;
    @Autowired
    CodeRuleBuilder codeRuleBuilder;
    @Autowired
    SoHeaderRepository soHeaderRepository;
    @Autowired
    OrderRepository orderRepository;

    public void validat(SoLine soLine){
        if(soLine.getSoHeaderId() ==null){
            throw new CommonException("headerId不能为空");
        }
        String status = soHeaderRepository.selectOrderStatusByPrimarKey(soLine.getSoHeaderId());
        if(soLine.getOrderQuantity() == null ){
            throw new CommonException("orderQuantity不能为空");
        }
        if(soLine.getOrderQuantity().intValue()<0){
            throw new CommonException("数量必须大于0");
        }if (!(status.equals(OrderStatus.NEW) || status.equals(OrderStatus.CLOSED))){
            throw new CommonException("该状态下不可更新");
        }
    }
    @Override
    public SoLine createSoLine(SoLine soLine) {
        if(soLine.getOrderQuantity().intValue()<0){
           return null;
        }else {
            Integer maxLineNumber = soLineRepository.selectMaxLineNumber(soLine.getSoHeaderId());
            soLine.setLineNumber(maxLineNumber + 1);
            soLineRepository.createSoLine(soLine);
            return soLine;
        }
    }

    @Override
    public SoLine updateSoLine(SoLine soLine) {
        validat(soLine);
        soLineRepository.updateSoLine(soLine);
        return soLine;
    }

    @Override
    public OrderDTO updateSoLineAll(List<SoLine> soLineList) {
        Long id = soLineList.get(0).getSoHeaderId();
        SoLine soline = null;
        //soLineRepository.deleteByHeaderId(id);
        //soLineRepository.createSoLineList(soLineList);
        for (int i=0;i<soLineList.size();i++){
            soline = soLineList.get(i);
            validat(soline);
            soLineRepository.updateSoLine(soline);
        }
        //soLineRepository.updateSoLineList(soLineList);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = orderRepository.selectOrderById(id);
        orderDTO.setSoLineList(soLineRepository.selectByHeaderId(id));
        return orderDTO;
    }
}
