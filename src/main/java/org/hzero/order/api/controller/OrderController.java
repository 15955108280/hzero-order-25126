package org.hzero.order.api.controller;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseConstants;
import org.hzero.core.util.Results;
import org.hzero.mybatis.domian.Condition;
import org.hzero.order.api.config.SwaggerApiConfig;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.api.dto.OrderSummaryDTO;
import org.hzero.order.app.service.OrderService;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.domain.entity.SoLine;
import org.hzero.order.domain.repository.OrderRepository;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.hzero.order.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: hzero-order-25126
 * @description: 订单控制器
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Api(tags = SwaggerApiConfig.ORDER)
@RestController("orderController.v1")
@RequestMapping("/v1/{organizationId}/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SoHeaderRepository soHeaderRepository;

    @Autowired
    SoLineRepository soLineRepository;

    @Autowired
    OrderService orderService;

    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    @ApiOperation("根据组合条件查询订单摘要")
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    public ResponseEntity<Page<OrderSummaryDTO>> pageOrder(@PathVariable("organizationId") Long tenantId, SoHeader soHeader, PageRequest pageRequest){
        return Results.success(orderRepository.pageOrder(soHeader, pageRequest));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/details/{id}")
    @ApiOperation("根据订单头ID查询订单明细")
    public ResponseEntity<OrderDTO> pageDetailOrder(@PathVariable("organizationId") Long tenantId,@PathVariable Long id, PageRequest pageRequest){
        OrderDTO orderDTO = orderRepository.selectOrderById(id);
        orderDTO.setSoLineList(soLineRepository.selectByHeaderId(id));
        return Results.success(orderDTO);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    @ApiOperation("新增一条订单")
    public ResponseEntity<OrderDTO> createOrder(@PathVariable("organizationId") Long tenantId,@RequestBody OrderDTO orderDTO){
        return Results.success(orderService.createOrder(orderDTO));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/{id}")
    @ApiOperation("删除整个订单")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("organizationId") Long tenantId,@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return Results.success();
    }
}
