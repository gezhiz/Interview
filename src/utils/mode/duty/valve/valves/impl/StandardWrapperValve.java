package utils.mode.duty.valve.valves.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.impl.Wrapper;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.*;
import utils.mode.duty.valve.valves.filter.FilterChain;
import utils.mode.duty.valve.valves.filter.impl.FilterChainFactory;

/**
 * 基本的Context阀门
 * Created by gezz on 2017/9/5.
 */
public class StandardWrapperValve extends ValveBase implements Valve, Contained {

    @Override
    public void invoke(DutyBean dutyBean, ValveContext context) {
        System.out.println("standardWrapperValve executed !");
        if (getContainer() != null) {
            Wrapper wrapper = (Wrapper) getContainer();
            //在tomcat4里面，StandardWrapperValve类还承担了实现Filter过滤连的功能，
            // 创建过滤链，然后在过滤链接的末端调用Servlet的service方法
            FilterChain filterChain = FilterChainFactory.createApplicationFilterChain(this);
            filterChain.doFilter(dutyBean);
        }
    }

    @Override
    public void setContainer(Container container) {
        if (!(container instanceof Wrapper)) {
            throw new IllegalArgumentException("container must be instance of Context");
        }
        super.setContainer(container);
    }
}
