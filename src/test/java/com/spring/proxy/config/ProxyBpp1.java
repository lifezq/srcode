package com.spring.proxy.config;

import com.spring.proxy.BppTestBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.SpringProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Package com.spring.proxy.config
 * @ClassName ProxyBpp1
 * @Description 使用cglib创建代理bean
 * @Author Ryan
 * @Date 2022/8/25
 */
public class ProxyBpp1 implements BeanPostProcessor {

    private static final Logger LOGGER = LogManager.getLogger(ProxyBpp1.class);

    public ProxyBpp1() {
        System.out.println("ProxyBpp1 init...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BppTestBean) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            //标识Spring-generated proxies
            enhancer.setInterfaces(new Class[]{SpringProxy.class});
            //设置增强
            enhancer.setCallback((MethodInterceptor) (target, method, args, methodProxy) -> {
                if ("test1".equals(method.getName())) {
                    LOGGER.info("ProxyBpp1 开始执行...");
                      /*
                        主要是代理 BppTestBean的test1方法。其实这种方式创建的代理Bean是有使用问题的，
                        @Autowired字段没有注入进来，所以会有出现NPE。methodProxy.invokeSuper(target, args)，
                        这一行代码是有问题的，targe是代理类对象，而真实的对象是
                        postProcessBeforeInitialization(Object bean, String beanName) 中的bean对象，
                        此时bean对象@Autowired字段已经注入了。所以可以将methodProxy.invokeSuper(target, args)
                        修改为method.invoke(bean, args)解决无法注入@Autowired字段的问题。
                       */
//                    Object result = methodProxy.invokeSuper(target, args);
                    Object result = method.invoke(bean, args);
                    LOGGER.info("ProxyBpp1 结束执行...");
                    return result;
                }
//                return method.invoke(target, args);
                return method.invoke(bean, args);
            });

            return enhancer.create();
        }
        return bean;
    }
}
