package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * 阀门上下文
 * Created by gezz on 2017/9/5.
 */
public interface ValveContext {
    void invokeNext(DutyBean dutyBean);
}
