package org.hzero.order.api.controller;

import io.choerodon.core.base.BaseController;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.order.api.config.SwaggerApiConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.calendar.BaseCalendar;
/**
 * @program: hzero-order-25126
 * @description: 公司控制器
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 11:02
 */
@Api(tags = SwaggerApiConfig.COMPANY)
@RestController("companyController.v1")
@RequestMapping("/v1/{organizationId}/companies")
public class CompanyController extends BaseController {

}
