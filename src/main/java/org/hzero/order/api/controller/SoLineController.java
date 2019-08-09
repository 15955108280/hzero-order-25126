package org.hzero.order.api.controller;

import org.apache.poi.hpsf.Decimal;
import org.hzero.core.base.BaseController;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.hzero.order.api.config.SwaggerApiConfig;
import org.hzero.order.api.dto.OrderDTO;
import org.hzero.order.app.service.SoLineService;
import org.hzero.order.domain.entity.SoLine;
import org.hzero.order.domain.repository.SoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @program: hzero-order-25126
 * @description: 订单行控制器
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@Api(tags = SwaggerApiConfig.SOLINE)
@RestController("solineController.v1")
@RequestMapping("/v1/{organizationId}/solines")
public class SoLineController extends BaseController {

    @Autowired
    SoLineRepository soLineRepository;

    @Autowired
    SoLineService soLineService;

    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("{id}")
    @ApiOperation("根据订单头ID查询订单行")
    public ResponseEntity<List<SoLine>> querySoLine(@PathVariable("organizationId") Long tenantId,@PathVariable Long id){
        return Results.success(soLineRepository.querySoLine(id));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    @ApiOperation("新增订单行-单条")
    public ResponseEntity<SoLine> createSoLine(@PathVariable("organizationId") Long tenantId,@RequestBody SoLine soLine){
        this.validObject(soLine);
        return Results.success(soLineService.createSoLine(soLine));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    @ApiOperation("编辑订单行-单条，传入对象，在mapper层只对可更改数据更改")
    public ResponseEntity<SoLine> updateSoLine(@PathVariable("organizationId") Long tenantId, @RequestBody SoLine soLine){
        return Results.success(soLineService.updateSoLine(soLine));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/all")
    @ApiOperation("编辑订单行-多条")
    public ResponseEntity<OrderDTO> updateSoLineAll(@PathVariable("organizationId") Long tenantId, @RequestBody List<SoLine> soLineList){
        return Results.success(soLineService.updateSoLineAll(soLineList));
    }
}
