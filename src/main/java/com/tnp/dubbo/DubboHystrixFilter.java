package com.tnp.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.*;
import com.tnp.util.BeanUtils;

import java.util.List;

/**
 * 扩展dubbo filter，提供hystrix功能，在consumercontext之后启动，提供RpcContext
 */
@Activate(group = Constants.CONSUMER)
public class DubboHystrixFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtils.class);

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        List<DubboHystrixInvokeListener> beans = BeanUtils.getBeans(DubboHystrixInvokeListener.class);

        return invoker.invoke(invocation);
    }
}
