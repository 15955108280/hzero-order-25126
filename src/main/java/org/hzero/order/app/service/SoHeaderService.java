package org.hzero.order.app.service;

import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.domain.entity.SoHeader;

import java.text.ParseException;
/**
 * @program: hzero-order-25126
 * @description: 订单头服务
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
public interface SoHeaderService {
    SoHeader createSoHeader(SoHeader soHeader) throws ParseException;

    SoHeader updateSoHeader(SoHeader soHeader);

    OrderDTO submitSoHeader(Long id);

    OrderDTO approveSoHeader(Long id);

    OrderDTO rejectSoHeader(Long id);
}
