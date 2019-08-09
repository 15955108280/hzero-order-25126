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
import java.util.Date;
/**
 * @program: hzero-order-25126
 * @description: 物料实体类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@ApiModel("物料主数据")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_item")
public class Item extends AuditDomain {
    @Id
    @GeneratedValue
    private Long itemId;
    @NotNull(message = "物料编码不能为空")
    @ApiModelProperty("物料编码")
    private String itemCode;
    @NotNull(message = "物料单位不能为空")
    @ApiModelProperty("物料单位")
    private String itemUom;
    @NotNull(message = "物料描述不能为空")
    @ApiModelProperty("物料描述")
    private String itemDescription;
    @NotNull(message = "可销售标识不能为空")
    @ApiModelProperty("可销售标识")
    private Boolean saleableFlag;
    @ApiModelProperty("生效起始时间")
    private Date start_activeDate;
    @ApiModelProperty("生效结束时间")
    private Date end_activeDate;
    private Boolean enabledFlag;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Boolean getSaleableFlag() {
        return saleableFlag;
    }

    public void setSaleableFlag(Boolean saleableFlag) {
        this.saleableFlag = saleableFlag;
    }

    public Date getStart_activeDate() {
        return start_activeDate;
    }

    public void setStart_activeDate(Date start_activeDate) {
        this.start_activeDate = start_activeDate;
    }

    public Date getEnd_activeDate() {
        return end_activeDate;
    }

    public void setEnd_activeDate(Date end_activeDate) {
        this.end_activeDate = end_activeDate;
    }

    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
