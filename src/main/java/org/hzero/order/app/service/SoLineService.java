package org.hzero.order.app.service;

import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.domain.entity.SoLine;

import java.util.List;
/**
 * @program: hzero-order-25126
 * @description: 订单行服务
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
public interface SoLineService {
    SoLine createSoLine(SoLine soLine);

    SoLine updateSoLine(SoLine soLine);

    OrderDTO updateSoLineAll(List<SoLine> soLineList);
}
