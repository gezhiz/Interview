package utils.mode.duty.valve.container;

import utils.mode.duty.valve.valves.Contained;
import utils.mode.duty.valve.valves.Pipeline;
import utils.mode.duty.valve.valves.impl.StandardPipeline;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.domain.DutyBean;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器类的基类
 * Created by gezz on 2017/9/1.
 */
public abstract class ContainerBase implements Pipeline, Container {

    private String name = "unknow name engine";
    private Container parent = null;
    private Map<String, Container> children = new HashMap<String, Container>();
    private Pipeline pipeline = new StandardPipeline(this);

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Container container) {
        synchronized (children) {
            children.put(container.getName(), container);
        }
    }

    public Map<String, Container> getChildren() {
        return children;
    }

    @Override
    public Container getParent() {
        return parent;
    }

    @Override
    public void setParent(Container parent) {
        this.parent = parent;
    }

    @Override
    public void setBasicValve(Valve basicValve) {
        if (basicValve instanceof Contained) {
            ((Contained) basicValve).setContainer(this);
        }
        pipeline.setBasicValve(basicValve);
    }

    @Override
    public void invoke(DutyBean dutyBean) {
        if (pipeline == null) {
            throw new IllegalArgumentException("pipeline can not be null !");
        }
        pipeline.invoke(dutyBean);
    }

    @Override
    public void addValve(Valve valve) {
        pipeline.addValve(valve);
    }

    @Override
    public Valve[] getValves() {
        return pipeline.getValves();
    }

    @Override
    public void removeValve(Valve valve) {
        pipeline.removeValve(valve);
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }
}
