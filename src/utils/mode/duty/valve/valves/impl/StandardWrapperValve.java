package utils.mode.duty.valve.valves.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.impl.Context;
import utils.mode.duty.valve.container.impl.Wrapper;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.Contained;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.valves.ValveBase;
import utils.mode.duty.valve.valves.ValveContext;

/**
 * 基本的Context阀门
 * Created by gezz on 2017/9/5.
 */
public class StandardWrapperValve extends ValveBase implements Valve, Contained {

    @Override
    public void invoke(DutyBean dutyBean, ValveContext context) {
        if (getContainer() != null) {
            Wrapper wrapper = (Wrapper) getContainer();
            wrapper.getServlet().service(dutyBean.getRequest(),dutyBean.getResponse());
        }
        System.out.println("standardWrapperValve executed !");
    }

    @Override
    public void setContainer(Container container) {
        if (!(container instanceof Wrapper)) {
            throw new IllegalArgumentException("container must be instance of Context");
        }
        super.setContainer(container);
    }
}
