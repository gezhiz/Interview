package utils.mode.duty.valve.valves.filter.impl;

import utils.mode.duty.valve.container.impl.Wrapper;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.filter.Filter;
import utils.mode.duty.valve.valves.filter.FilterChain;
import utils.mode.duty.valve.valves.impl.StandardWrapperValve;

/**
 * Created by gezz on 2017/9/5.
 */
public class FilterChainFactory {
    public static ApplicationFilterChain createApplicationFilterChain(StandardWrapperValve wrapperValve) {
        ApplicationFilterChain filterChain = new ApplicationFilterChain();
        Wrapper wrapper = (Wrapper) wrapperValve.getContainer();
        filterChain.setServlet(wrapper.getServlet());
        //简单起见，手动添加了几个过滤链
        filterChain.addFilter(new Filter() {
            @Override
            public void doFilter(DutyBean dutyBean, FilterChain filterChain) {
                System.out.println("Filter1 executed doFilter before !");
//                filterChain.doFilter(dutyBean);//如果没有调用链路的doFilter,则后续的过滤器将不会得到执行
                System.out.println("Filter1 executed doFilter after !");
            }
        });
        filterChain.addFilter(new Filter() {
            @Override
            public void doFilter(DutyBean dutyBean, FilterChain filterChain) {
                System.out.println("Filter2 executed doFilter before !");
                filterChain.doFilter(dutyBean);
                System.out.println("Filter2 executed doFilter after !");
            }
        });
        return filterChain;
    }
}
