package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.Host;
import utils.mode.duty.valve.domain.DutyBean;

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
