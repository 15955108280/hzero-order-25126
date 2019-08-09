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
 * @description: 公司实体类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@ApiModel("公司主数据")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_company")
public class Company extends AuditDomain {
    @Id
    @GeneratedValue
    private Long companyId;
    @NotNull(message = "公司编号不能为空")
    @ApiModelProperty("公司编号")
    private String companyNumber;
    @NotNull(message = "公司名称不能为空")
    @ApiModelProperty("公司名称")
    private String companyName;
    @NotNull(message = "启用标识不能为空")
    @ApiModelProperty("启用标识")
    private boolean enabledFlag;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
