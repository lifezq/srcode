package com.java.convert.beanCopier;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Arrays;
import java.util.List;

/**
 * @Package com.java.convert.beanCopier
 * @ClassName BeanCopierTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public class BeanCopierTest {

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
        a.setIds(Arrays.asList(1, 2, 3));

        B b = new B();
        BeanCopier beanCopier = BeanCopier.create(A.class, B.class, false);
        beanCopier.copy(a, b, null);

        for (String id : b.getIds()) { //抛出异常：ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
            System.out.println(id);
        }
    }
}
