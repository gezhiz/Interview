package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * Created by gezz on 2017/9/1.
 */
public interface Pipeline {
    void invoke(DutyBean dutyBean);
    void addValve(Valve valve);
    Valve[] getValves();
    void removeValve(Valve valve);
    void setBasicValve(Valve basicValve);
}
