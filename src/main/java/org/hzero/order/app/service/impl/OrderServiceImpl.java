package org.hzero.order.app.service.impl;

import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.app.service.OrderService;
import org.hzero.order.domain.entity.OrderStatus;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.domain.entity.SoLine;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.hzero.order.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hzero-order-25126
 * @description: 订单service实现类
 * @author: Xingpeng.Yang
 * @create: 2019-08-07 18:47
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    SoHeaderRepository soHeaderRepository;
    @Autowired
    SoLineRepository soLineRepository;
    @Autowired
    CodeRuleBuilder codeRuleBuilder;
    @Override
    @Transactional(rollbackFor=Exception.class)
    public OrderDTO createOrder(OrderDTO orderDTO) {
        SoHeader soHeader = new SoHeader();
        soHeader.setSoHeaderId(orderDTO.getSoHeaderId());
        soHeader.setCompanyId(orderDTO.getCompanyId());
        soHeader.setCustomerId(orderDTO.getCustomerId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        try {
            soHeader.setOrderDate(sdf.parse(sdf.format(now)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        soHeader.setOrderNumber(codeRuleBuilder.generateCode(119L, "HZERO.25126.ORDER.NUMBER", "GLOBAL", "GLOBAL", null));
        soHeader.setOrderStatus(OrderStatus.NEW);
        soHeaderRepository.createSoHeaderWithId(soHeader);
        List<SoLine> soLineList= orderDTO.getSoLineList();
        for(int i=0;i<soLineList.size();i++){
            soLineList.get(i).setSoHeaderId(soHeader.getSoHeaderId());
        }
        soLineRepository.createSoLineList(soLineList);
        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void deleteOrder(Long id) {
        soHeaderRepository.deleteByPrimaryKey(id);
        soLineRepository.deleteByHeaderId(id);
    }
}
