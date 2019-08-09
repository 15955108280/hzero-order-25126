package test;

import javafx.application.Application;
import org.hzero.order.OrderApplication;
import org.hzero.order.domain.entity.SoHeader;
import org.hzero.order.infra.mapper.OrderMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @program: hzero-order-25126
 * @description: 测试类
 * @author: Xingpeng.Yang
 * @create: 2019-08-06 17:51
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderApplication.class,Test.class})
public class Test {
    @Autowired
    OrderMapper orderMapper;
    @org.junit.Test
    public void testUserMapperImpl() throws IOException {

        SoHeader soHeader = new SoHeader();
        System.out.println(orderMapper.selectOrder(soHeader));
    }
}
