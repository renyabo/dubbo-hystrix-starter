package com.tnp.util;

import com.tnp.dubbo.DubboHystrixInvokeListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * spring applicationContext持有者
 */
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        Assert.notNull(applicationContext, "spring application context is null");
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        Assert.notNull(applicationContext, "spring application context is null");
        return applicationContext.getBean(clazz);
    }

    public static <T> List<T> getBeans(Class<T> clazz) {
        Map<String, T> beans = applicationContext.getBeansOfType(clazz);
        if (beans != null && !beans.isEmpty()) {
            return new ArrayList<T>(beans.values());
        }
        return new ArrayList<T>();
    }

}
