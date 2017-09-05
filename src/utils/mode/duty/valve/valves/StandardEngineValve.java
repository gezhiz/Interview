package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.Engine;
import utils.mode.duty.valve.container.Host;
import utils.mode.duty.valve.domain.DutyBean;

/**
 * Created by gezz on 2017/9/5.
 */
public class StandardEngineValve extends ValveBase implements Valve, Contained {

    @Override
    public void invoke(DutyBean dutyBean, ValveContext context) {
        System.out.println("standardEngineValve executed !");
        if (getContainer() != null) {
            //为了简单起见，只要找到了下一个类型为Host的容器，就进入下一个责任链
            Engine engine = (Engine) getContainer();
            Host host = engine.mapper(dutyBean);
            if (host != null) {
                host.invoke(dutyBean);
            }
        }
    }

    @Override
    public Container getContainer() {
        return super.getContainer();
    }

    @Override
    public void setContainer(Container container) {
        if (!(container instanceof Engine)) {
            throw new IllegalArgumentException("container must be instance of Engine");
        }
        super.setContainer(container);
    }
}
