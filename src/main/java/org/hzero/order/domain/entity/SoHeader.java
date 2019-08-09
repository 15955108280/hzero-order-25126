package org.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hzero.boot.platform.lov.annotation.LovValue;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * @program: hzero-order-25126
 * @description: 订单头实体类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@ApiModel("销售订单头")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_header")
public class SoHeader extends AuditDomain {
    @Id
    @GeneratedValue
    private Long soHeaderId;
    @NotNull(message = "订单编号不能为空")
    @ApiModelProperty("订单编号")
    private String orderNumber;
    @NotNull(message = "公司ID不能为空")
    @ApiModelProperty("公司ID")
    private Long companyId;
    @NotNull(message = "订单日期不能为空")
    @ApiModelProperty("订单日期")
    private Date orderDate;
    @NotNull(message = "订单状态不能为空")
    @ApiModelProperty("订单状态")
    @LovValue(lovCode = "HZERO.25126.ORDER.STATUS")
    private String orderStatus;
    @NotNull(message = "客户ID不能为空")
    @ApiModelProperty("客户ID")
    private Long customerId;
/*    private Company company;
    private  Customer customer;*/

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


}
