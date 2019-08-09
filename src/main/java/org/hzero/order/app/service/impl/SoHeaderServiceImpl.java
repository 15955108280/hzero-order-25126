package org.hzero.order.app.service.impl;

import io.choerodon.core.exception.CommonException;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.app.service.SoHeaderService;
import org.hzero.order.domain.entity.OrderStatus;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @program: hzero-order-25126
 * @description: 订单头服务实现
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Service
public class SoHeaderServiceImpl implements SoHeaderService {
    @Autowired
    SoHeaderRepository soHeaderRepository;
    @Autowired
    CodeRuleBuilder codeRuleBuilder;
    @Override
    public SoHeader createSoHeader(SoHeader soHeader){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        try {
            soHeader.setOrderDate(sdf.parse(sdf.format(now)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        soHeader.setOrderNumber(codeRuleBuilder.generateCode(119L, "HZERO.25126.ORDER.NUMBER", "GLOBAL", "GLOBAL", null));
        soHeader.setOrderStatus(OrderStatus.NEW);
        soHeaderRepository.createSoHeader(soHeader);
        return soHeader;
    }

    @Override
    public SoHeader updateSoHeader(SoHeader soHeader) {
        String status = soHeaderRepository.selectOrderStatusByPrimarKey(soHeader.getSoHeaderId());
        if (!(status.equals(OrderStatus.NEW) || status.equals(OrderStatus.CLOSED))){
            throw new CommonException("该状态下不可更新");
        }
        return soHeaderRepository.updateHeader(soHeader);
    }

    @Override
    public OrderDTO submitSoHeader(Long id) {
        String status = soHeaderRepository.selectOrderStatusByPrimarKey(id);
        if (!(status.equals(OrderStatus.NEW) || status.equals(OrderStatus.CLOSED))){
            throw new CommonException("该状态下不可提交");
        }
        return soHeaderRepository.submitSoHeader(id);
    }

    @Override
    public OrderDTO approveSoHeader(Long id) {
        return soHeaderRepository.approveSoHeader(id);
    }

    @Override
    public OrderDTO rejectSoHeader(Long id) {
        return soHeaderRepository.rejectSoHeader(id);
    }
}
