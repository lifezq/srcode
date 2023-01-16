package com.spring.proxy.config;

import com.spring.proxy.BppTestBean;
import org.aopalliance.intercept.MethodInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Package com.spring.proxy.config
 * @ClassName ProxyBpp2
 * @Description 使用ProxyFactoryBean创建代理bean
 * 使用ProxyFactoryBean创建代理Bean的时候，一定要一个targe对象的。
 * Advisor在切入的时候，会逐个执行Advice。invocation.getThis()就
 * 是在通过ProxyFactoryBean创建代理Bean的时候传入的target对象。由
 * 于target对象就是postProcessBeforeInitialization(Object bean, String beanName)
 * 中的bean对象，所以@Autowired字段也已经注入进来了
 * @Author Ryan
 * @Date 2022/8/25
 */
public class ProxyBpp2 implements BeanPostProcessor {
    private static final Logger LOGGER = LogManager.getLogger(ProxyBpp2.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BppTestBean) {
            ProxyFactoryBean pfb = new ProxyFactoryBean();
            pfb.setTarget(bean);
            pfb.setAutodetectInterfaces(false);
            NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
            advisor.addMethodName("test1");
            advisor.setAdvice((MethodInterceptor) invocation -> {
                LOGGER.info("ProxyBpp2 开始执行...");
                Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
                LOGGER.info("ProxyBpp2 结束执行...");
                return result;
            });
            pfb.addAdvisor(advisor);

            return pfb.getObject();
        }
        return bean;
    }
}