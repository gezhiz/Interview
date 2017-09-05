package utils.mode.duty.valve.filter;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * 过滤器，责任链,FilterChain责任链的节点
 * Created by gezz on 2017/9/5.
 */
public interface Filter {
    void doFilter(DutyBean dutyBean, FilterChain filterChain);
}
