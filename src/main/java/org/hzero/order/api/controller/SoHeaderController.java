package org.hzero.order.api.controller;

import io.choerodon.core.base.BaseController;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.hzero.order.api.config.SwaggerApiConfig;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.app.service.SoHeaderService;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
/**
 * @program: hzero-order-25126
 * @description: 订单头控制器
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Api(tags = SwaggerApiConfig.SOHEADER)
@RestController("soheaderController.v1")
@RequestMapping("/v1/{organizationId}/soheaders")
public class SoHeaderController extends BaseController {

    @Autowired
    SoHeaderRepository soHeaderRepository;

    @Autowired
    SoHeaderService soHeaderService;

/*    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    @ApiOperation("根据条件查询订单")
    public ResponseEntity<Page<SoHeader>> pageSoHeader(SoHeader soHeader, PageRequest pageRequest){
        return Results.success(soHeaderRepository.pageSoHeader(soHeader, pageRequest));
    }*/

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    @ApiOperation("创建头信息")
    public ResponseEntity<SoHeader> createSoHeader(@PathVariable("organizationId") Long tenantId,@RequestBody SoHeader soHeader){
        try {
            return Results.success(soHeaderService.createSoHeader(soHeader));
        } catch (ParseException e) {
            e.printStackTrace();
            return Results.error();
        }
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    @ApiOperation("更新头信息，传入对象在mapper中只更新需要更改的字段")
    public ResponseEntity<SoHeader> updateSoHeader(@PathVariable("organizationId") Long tenantId,@RequestBody SoHeader soHeader){
        return Results.success(soHeaderService.updateSoHeader(soHeader));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/submit/{id}")
    @ApiOperation("点击提交按钮")
    public ResponseEntity<OrderDTO> submitSoHeader(@PathVariable("organizationId") Long tenantId,@PathVariable Long id,String button){
        return Results.success(soHeaderService.submitSoHeader(id));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/approve/{id}")
    @ApiOperation("点击审批按钮")
    public ResponseEntity<OrderDTO> approveSoHeader(@PathVariable("organizationId") Long tenantId,@PathVariable Long id,String button){
        return Results.success(soHeaderService.approveSoHeader(id));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/reject/{id}")
    @ApiOperation("点击拒绝按钮")
    public ResponseEntity<OrderDTO> rejectSoHeader(@PathVariable("organizationId") Long tenantId, @PathVariable Long id, String button){
        return Results.success(soHeaderService.rejectSoHeader(id));
    }

}
