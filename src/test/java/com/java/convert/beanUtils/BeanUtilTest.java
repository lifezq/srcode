package com.java.convert.beanUtils;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Package com.java.convert.beanUtils
 * @ClassName BeanUtilTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public class BeanUtilTest {

    @Data
    class A {
        private String name;
        private List<Integer> ids;
    }

    @Data
    class B {
        private String name;
        private List<String> ids;
    }

    @Test
    public void testCopyProperty() {
        A a = new A();
        a.setName("张三");
        a.setIds(Arrays.asList(1, 2, 3, 4));

        B b = new B();
        BeanUtils.copyProperties(a, b);

        for (String id : b.getIds()) { // 抛出异常： NullPointerException
            System.out.println(id);
        }
    }
}
