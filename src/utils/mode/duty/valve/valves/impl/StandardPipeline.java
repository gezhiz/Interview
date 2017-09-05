package utils.mode.duty.valve.valves.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.Pipeline;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.valves.ValveContext;

/**
 * Created by gezz on 2017/9/5.
 */
public class StandardPipeline implements Pipeline {
    private Container container;
    protected Valve valves[] = new Valve[0];
    protected  Valve basicValve = null;

    public StandardPipeline(Container container) {
        this.container = container;
    }

    @Override
    public void invoke(DutyBean dutyBean) {
        new StandardPipelineValveContext().invokeNext(dutyBean);
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public void addValve(Valve valve) {
        synchronized (valves) {
            Valve[] results = new Valve[valves.length +1];
            System.arraycopy(valves, 0,results,0, valves.length);
            results[valves.length] = valve;
            valves = results;
        }
    }

    @Override
    public Valve[] getValves() {
        return valves;
    }

    @Override
    public void removeValve(Valve valve) {
        synchronized (valves) {
            //先找到valve对应的坐标
            int j = -1;
            for (int i = 0; i < valves.length; i++) {
                if (valve == valves[i]) {
                    j = i;
                    break;
                }
            }
            //未找到
            if (j < 0)
                return;
            //找到了，移除对应的valve
            Valve results[] = new Valve[valves.length - 1];
            int n = 0;
            for (int i = 0; i < valves.length; i++) {
                if (i == j)
                    continue;
                results[n++] = valves[i];
            }
            valves = results;
        }
    }

    @Override
    public void setBasicValve(Valve basicValve) {
        this.basicValve = basicValve;
    }

    protected class StandardPipelineValveContext implements ValveContext {
        private int stage = 0;

        @Override
        public void invokeNext(DutyBean dutyBean) {
            int subscript = stage;
            stage++;
            if (subscript < valves.length) {
                valves[subscript].invoke(dutyBean,this);
            } else if (subscript == valves.length && basicValve != null) {
                basicValve.invoke(dutyBean, this);
            } else {
                throw new IllegalArgumentException(getContainer().getName() + " basic valve can not be null !");
            }
        }

    }
}
