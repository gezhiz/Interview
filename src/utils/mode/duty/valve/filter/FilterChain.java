package utils.mode.duty.valve.filter;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * Created by gezz on 2017/9/5.
 */
public interface FilterChain {
    void doFilter(DutyBean dutyBean);
}
