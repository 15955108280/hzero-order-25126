package org.hzero.order.api.dto;

import org.hzero.boot.platform.lov.annotation.LovValue;
import org.hzero.order.domain.entity.SoLine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: hzero-order-25126
 * @description: 订单明细
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 14:42
 */
public class OrderSummaryDTO implements Serializable {
    private String orderNumber;
    private String companyName;
    private String customerName;
    private Long soHeaderId;
    private Date orderDate;
    @LovValue(lovCode = "HZERO.25126.ORDER.STATUS",meaningField="orderStatusMeaning")
    private String orderStatus;
    private String orderStatusMeaning;
    private Double money;

    public String getOrderStatusMeaning() {
        return orderStatusMeaning;
    }

    public void setOrderStatusMeaning(String orderStatusMeaning) {
        this.orderStatusMeaning = orderStatusMeaning;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
