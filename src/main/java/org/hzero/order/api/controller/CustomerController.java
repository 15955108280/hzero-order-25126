package org.hzero.order.api.controller;

import io.choerodon.core.base.BaseController;
import io.swagger.annotations.Api;
import org.hzero.order.api.config.SwaggerApiConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @program: hzero-order-25126
 * @description: 顾客控制器
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 11:03
 */
@Api(tags = SwaggerApiConfig.CUSTOMER)
@RestController("customerController.v1")
@RequestMapping("/v1/{organizationId}/customers")
public class CustomerController extends BaseController {
}
