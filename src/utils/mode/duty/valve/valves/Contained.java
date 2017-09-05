package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.container.Container;

/**
 * 给Pipeline装配Container，让pipeline拥有获取Container的能力
 * Created by gezz on 2017/9/5.
 */
public interface Contained {
    Container getContainer();
    void setContainer(Container container);
}
