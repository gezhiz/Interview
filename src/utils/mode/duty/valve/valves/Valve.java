package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * Created by gezz on 2017/9/5.
 */
public interface Valve {
    void invoke(DutyBean dutyBean, ValveContext context);
}
