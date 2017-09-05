package utils.mode.duty.valve.filter.test;

import org.junit.Test;
import utils.mode.duty.valve.container.impl.Wrapper;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.domain.Servlet;
import utils.mode.duty.valve.filter.FilterChain;
import utils.mode.duty.valve.filter.impl.FilterChainFactory;
import utils.mode.duty.valve.valves.impl.StandardWrapperValve;

/**
 * Created by gezz on 2017/9/5.
 */
public class FilterTest {
    @Test
    public void test() {
        StandardWrapperValve standardWrapperValve = new StandardWrapperValve();
        standardWrapperValve.setContainer(new Wrapper(new Servlet()));
        FilterChain filterChain = FilterChainFactory.createApplicationFilterChain(standardWrapperValve);
        filterChain.doFilter(new DutyBean("dutyType"));
    }
}
