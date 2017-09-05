package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.container.Container;

/**
 * Created by gezz on 2017/9/5.
 */
public interface Contained {
    Container getContainer();
    void setContainer(Container container);
}
