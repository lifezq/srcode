package com.spring.ioc;

import com.record.srcode.config.AsyncConfig;
import com.record.srcode.entity.User;
import com.record.srcode.entity.impl.BusinessPerson;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yangqianlei
 * @version 1.0 2020/11/29
 */
public class IocTest {
    private static Logger log = Logger.getLogger("IocTest");

    @Test
    public void personTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AsyncConfig.class);
        User u = ctx.getBean(User.class);
        System.out.printf("编号:%s\n", u.getId());
        System.out.printf("名称:%s\n", u.getUserName());
        System.out.printf("备注:%s\n", u.getNote());

        log.log(Level.INFO, String.format("编号:%s", u.getId()));

        BusinessPerson bp = ctx.getBean(BusinessPerson.class);
        bp.service();
    }
}
