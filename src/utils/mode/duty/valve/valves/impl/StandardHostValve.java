package utils.mode.duty.valve.valves.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.impl.Context;
import utils.mode.duty.valve.container.impl.Host;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.Contained;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.valves.ValveBase;
import utils.mode.duty.valve.valves.ValveContext;

/**
 * 基本的Host阀门
 * Created by gezz on 2017/9/5.
 */
public class StandardHostValve extends ValveBase implements Valve, Contained {

    @Override
    public void invoke(DutyBean dutyBean, ValveContext valveContext) {
        System.out.println("standardHostValve executed !");
        if (getContainer() != null) {
            //为了简单起见，只要找到了下一个类型为Host的容器，就进入下一个责任链
            Host host = (Host) getContainer();
            Context context  = host.mapper(dutyBean);
            if (context != null) {
                context.invoke(dutyBean);
            }
        }
    }

    @Override
    public void setContainer(Container container) {
        if (!(container instanceof Host)) {
            throw new IllegalArgumentException("container must be instance of Host");
        }
        super.setContainer(container);
    }
}
