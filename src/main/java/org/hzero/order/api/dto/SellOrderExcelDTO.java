package org.hzero.order.api.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @program: hzero-order-25126
 * @description: 表格导入实体类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
public class SellOrderExcelDTO {
    private String order_number;

    private String company_number;

    private String order_date;

    private String order_status;

    private String customer_number;

    private Integer line_number;

    private String item_code;

    private BigDecimal order_quantity;

    private String order_quantity_uom;

    private BigDecimal unit_selling_price;

    private String description;

    private String addition1;
    private String addition2;
    private String addition3;
    private String addition4;
    private String addition5;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getCompany_number() {
        return company_number;
    }

    public void setCompany_number(String company_number) {
        this.company_number = company_number;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public Integer getLine_number() {
        return line_number;
    }

    public void setLine_number(Integer line_number) {
        this.line_number = line_number;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public BigDecimal getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(BigDecimal order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getOrder_quantity_uom() {
        return order_quantity_uom;
    }

    public void setOrder_quantity_uom(String order_quantity_uom) {
        this.order_quantity_uom = order_quantity_uom;
    }

    public BigDecimal getUnit_selling_price() {
        return unit_selling_price;
    }

    public void setUnit_selling_price(BigDecimal unit_selling_price) {
        this.unit_selling_price = unit_selling_price;
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
