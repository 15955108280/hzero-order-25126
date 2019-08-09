package org.hzero.order.app.service.impl;

import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;
import org.hzero.order.domain.repository.SoHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
/**
 * @program: hzero-order-25126
 * @description: 服务调度定时将订单关闭
 * @author: Xingpeng.Yang
 * @create: 2019-08-06
 */
@JobHandler("jobservice-25126")
public class JobService implements IJobHandler {
    @Autowired
    SoHeaderRepository soHeaderRepository;
    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {
        // 刷新任务进度及描述
        tool.updateProgress(50, "任务执行中...");
        // 任务日志记录
        tool.info("示例任务执行成功！");
        soHeaderRepository.closeSoHeader();
        return ReturnT.SUCCESS;
    }
}