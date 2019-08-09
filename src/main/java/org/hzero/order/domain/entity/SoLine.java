package org.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
/**
 * @program: hzero-order-25126
 * @description: 订单行实体类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@ApiModel("销售订单行信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_line")
public class SoLine extends AuditDomain {
    @Id
    @GeneratedValue
    private  Long soLineId;
    @NotNull(message = "订单头ID不能为空")
    @ApiModelProperty("订单头ID")
    private  Long soHeaderId;
    @NotNull(message = "行号不能为空")
    @ApiModelProperty("行号")
    private  Integer lineNumber;
    @NotNull(message = "产品ID不能为空")
    @ApiModelProperty("产品ID")
    private  Long itemId;
    @NotNull(message = "数量不能为空")
    @ApiModelProperty("数量")
    private BigDecimal orderQuantity;
    @NotNull(message = "产品单位不能为空")
    @ApiModelProperty("产品单位")
    private String orderQuantityUom;
    @NotNull(message = "销售单价不能为空")
    @ApiModelProperty("销售单价")
    private BigDecimal unitSellingPrice;
    @ApiModelProperty("备注")
    private String description;
    @ApiModelProperty("附加信息1")
    private String addition1;
    @ApiModelProperty("附加信息2")
    private String addition2;
    @ApiModelProperty("附加信息3")
    private String addition3;
    @ApiModelProperty("附加信息4")
    private String addition4;
    @ApiModelProperty("附加信息5")
    private String addition5;
    @ApiModelProperty("物料编号")
    @Transient
    private String itemCode;
    @ApiModelProperty("物料描述")
    @Transient
    private  String itemDescription;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }
}
