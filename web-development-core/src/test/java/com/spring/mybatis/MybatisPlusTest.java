package com.spring.mybatis;

import com.record.srcode.service.impl.ProductServiceImpl;
import com.record.srcode.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package com.spring.mybatis
 * @ClassName MybatisPlusTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/5
 */
@ComponentScan(basePackages = "com.record.srcode")
@MapperScan(basePackages = {"com.record.srcode.mapper"})
@SpringBootTest(classes = {UserServiceImpl.class, ProductServiceImpl.class})
public class MybatisPlusTest {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ProductServiceImpl productService;

    @Test
    public void testMybatisPlusDatasourceDynamic() {
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
