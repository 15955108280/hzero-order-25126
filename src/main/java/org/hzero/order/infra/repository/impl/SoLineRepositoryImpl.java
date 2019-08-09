package org.hzero.order.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.order.domain.entity.Company;
import org.hzero.order.domain.entity.SoLine;
import org.hzero.order.domain.repository.CompanyRepository;
import org.hzero.order.domain.repository.SoLineRepository;
import org.hzero.order.infra.mapper.SoLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SoLineRepositoryImpl extends BaseRepositoryImpl<SoLine> implements SoLineRepository {

    @Autowired
    SoLineMapper soLineMapper;
    @Override
    public List<SoLine> querySoLine(Long id) {
        return soLineMapper.querySoLine(id);
    }

    @Override
    public void createSoLine(SoLine soLine) {
        soLineMapper.insert(soLine);
    }

    @Override
    public List<SoLine> selectByHeaderId(Long id) {
        return soLineMapper.selectByHeaderId(id);
    }

    @Override
    public Integer selectMaxLineNumber(Long id) {
        return soLineMapper.selectMaxLineNumber(id);
    }

    @Override
    public void updateSoLine(SoLine soLine) {
        soLineMapper.updateSoLine(soLine);
    }

    @Override
    public void createSoLineList(List<SoLine> soLineList) {
        soLineMapper.createSoLineList(soLineList);
    }

    @Override
    public void deleteByHeaderId(Long id) {
        soLineMapper.deleteByHeaderId(id);
    }
}

