package utils.mode.duty.valve.valves.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.impl.Host;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.Contained;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.valves.ValveBase;
import utils.mode.duty.valve.valves.ValveContext;

/**
 * Created by gezz on 2017/9/5.
 */
public class StandardHostValve extends ValveBase implements Valve, Contained {

    @Override
    public void invoke(DutyBean dutyBean, ValveContext context) {
        System.out.println("standardHostValve executed !");
    }

    @Override
    public Container getContainer() {
        return super.getContainer();
    }

    @Override
    public void setContainer(Container container) {
        if (!(container instanceof Host)) {
            throw new IllegalArgumentException("container must be instance of Host");
        }
        super.setContainer(container);
    }
}
