package org.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * @program: hzero-order-25126
 * @description: 顾客实体类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@ApiModel("客户主数据")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_customer")
public class Customer extends AuditDomain {
    @Id
    @GeneratedValue
    private Long customerId;
    @NotNull(message = "客户编号不能为空")
    @ApiModelProperty("客户编号")
    private String customerNumber;
    @NotNull(message = "客户名称不能为空")
    @ApiModelProperty("客户名称")
    private String customerName;
    @NotNull(message = "公司ID不能为空")
    @ApiModelProperty("公司ID")
    private Long companyId;
    @NotNull(message = "启用标识不能为空")
    @ApiModelProperty("启用标识")
    private Boolean enabledFlag;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
