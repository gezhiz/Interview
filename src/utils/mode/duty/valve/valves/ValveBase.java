package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.container.Container;

/**
 * Created by gezz on 2017/9/5.
 */
public abstract class ValveBase implements Valve, Contained {
    private Container container = null;

    @Override
    public Container getContainer() {
        return container;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }
}
