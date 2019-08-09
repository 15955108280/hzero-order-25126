package org.hzero.order.app.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.choerodon.core.exception.CommonException;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.api.dto.SellOrderExcelDTO;
import org.hzero.order.domain.entity.*;
import org.hzero.order.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
/**
 * @program: hzero-order-25126
 * @description: 导入服务实现
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@ImportService(templateCode = "HZERO-ORDER-25126")
public class ImportServiceImpl implements IDoImportService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private SoLineRepository soLineRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Boolean doImport(String data) {
        // 获取自定义参数
        Map<String, Object> args = getArgs();
        SellOrderExcelDTO sellOrderExcelDTO = null;
        try {
            sellOrderExcelDTO = objectMapper.readValue(data, SellOrderExcelDTO.class);
        } catch (IOException e) {
            // 失败
            return false;
        }

        SoHeader querySoHeader = new SoHeader();
        querySoHeader.setOrderNumber(sellOrderExcelDTO.getOrder_number());
        SoHeader soHeader = soHeaderRepository.selectOne(querySoHeader);
        //插入头信息，若是已存在则不插入
        if(soHeader == null) {
            Company queryCompany = new Company();
            queryCompany.setEnabledFlag(true);
            queryCompany.setCompanyNumber(sellOrderExcelDTO.getCompany_number());
            Company company = companyRepository.selectOne(queryCompany);
            if (company == null) {
                //throw new CommonException("存在无效公司编码");
                return false;
            }
                Customer queryCustomer = new Customer();
            queryCustomer.setEnabledFlag(true);

            queryCustomer.setCustomerNumber(sellOrderExcelDTO.getCustomer_number());
            Customer customer = customerRepository.selectOne(queryCustomer);
            if (customer == null) {
               // throw new CommonException("存在无效员工编码");
                return false;
            }

            soHeader.setCompanyId(company.getCompanyId());
            soHeader.setCustomerId(customer.getCustomerId());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                soHeader.setOrderDate(sdf.parse(sellOrderExcelDTO.getOrder_date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            soHeader.setOrderNumber(sellOrderExcelDTO.getOrder_number());
            soHeaderRepository.createSoHeaderWithId(soHeader);
        }

        //soLineRepository.createSoLineList(orderDTO.getSoLineList());
        // 插入行信息
        SoLine soLine = new SoLine();
        Item queryItem = new Item();
        queryItem.setEnabledFlag(true);
        Item item = itemRepository.selectOne(queryItem);
        if (null == item){
            //throw new CommonException("存在无效物料编码");
            return false;
        }
        soLine.setSoHeaderId(soHeader.getSoHeaderId());
        soLine.setLineNumber(sellOrderExcelDTO.getLine_number());
        SoLine resLine =soLineRepository.selectOne(soLine);
        if(resLine != null){
            Integer newLineNumber = soLineRepository.selectMaxLineNumber(soHeader.getSoHeaderId());
            soLine.setLineNumber(newLineNumber+1);
        }
        soLine.setItemId(item.getItemId());
        soLine.setOrderQuantity(sellOrderExcelDTO.getOrder_quantity());
        soLine.setOrderQuantityUom(sellOrderExcelDTO.getOrder_quantity_uom());
        soLine.setUnitSellingPrice(sellOrderExcelDTO.getUnit_selling_price());
        soLine.setDescription(sellOrderExcelDTO.getDescription());
        soLine.setAddition1(sellOrderExcelDTO.getAddition1());
        soLine.setAddition2(sellOrderExcelDTO.getAddition2());
        soLine.setAddition3(sellOrderExcelDTO.getAddition3());
        soLine.setAddition4(sellOrderExcelDTO.getAddition4());
        soLine.setAddition5(sellOrderExcelDTO.getAddition5());
        soLineRepository.createSoLine(soLine);
        return true;
    }
}
