package com.tnp.dubbo;

/**
 * dubbo调用观察者，自主判断是否要对该次请求执行熔断
 */
public interface DubboHystrixInvokeListener {

    String groupKey();

}
