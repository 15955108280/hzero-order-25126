package org.hzero.order.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.domain.entity.Company;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.domain.entity.SoLine;
import org.hzero.order.domain.repository.CompanyRepository;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.hzero.order.infra.mapper.OrderMapper;
import org.hzero.order.infra.mapper.SoHeaderMapper;
import org.hzero.order.infra.mapper.SoLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SoHeaderRepositoryImpl extends BaseRepositoryImpl<SoHeader> implements SoHeaderRepository {

    @Autowired
    SoHeaderMapper soHeaderMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    SoLineMapper soLineMapper;
    @Override
    public void createSoHeader(SoHeader soHeader) {
        soHeaderMapper.insert(soHeader);
    }

    @Override
    public Page<SoHeader> pageSoHeader(SoHeader soHeader, PageRequest pageRequest) {
       // return  PageHelper.doPage(pageRequest, () -> soHeaderMapper.selectSoHeader(soHeader));
        return null;
    }

    @Override
    public String selectOrderStatusByPrimarKey(Long soHeaderId) {
        return soHeaderMapper.selectOrderStatusByPrimarKey(soHeaderId);
    }

    @Override
    public SoHeader updateHeader(SoHeader soHeader) {
        return soHeaderMapper.updateSoHeader(soHeader);
    }

    @Override
    public OrderDTO submitSoHeader(Long id) {
        soHeaderMapper.submitSoHeader(id);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = orderMapper.selectOrderById(id);
        orderDTO.setSoLineList(soLineMapper.selectByHeaderId(id));
        return orderDTO;
    }

    @Override
    public OrderDTO approveSoHeader(Long id) {
        soHeaderMapper.approveSoHeader(id);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = orderMapper.selectOrderById(id);
        orderDTO.setSoLineList(soLineMapper.selectByHeaderId(id));
        return orderDTO;
    }

    @Override
    public OrderDTO rejectSoHeader(Long id) {
        soHeaderMapper.rejectSoHeader(id);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = orderMapper.selectOrderById(id);
        orderDTO.setSoLineList(soLineMapper.selectByHeaderId(id));
        return orderDTO;
    }

    @Override
    public Long createSoHeaderWithId(SoHeader soHeader) {
        return soHeaderMapper.createSoHeaderWithId(soHeader);
    }

    @Override
    public void closeSoHeader() {
        soHeaderMapper.closeSoHeader();
    }
}
