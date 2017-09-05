package utils.mode.duty.valve.container.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.ContainerBase;
import utils.mode.duty.valve.valves.Pipeline;
import utils.mode.duty.valve.domain.DutyBean;

import java.util.Map;

/**
 * Created by gezz on 2017/9/1.
 */
public class Engine extends ContainerBase implements Pipeline, Container {

    public Host mapper(DutyBean dutyBean) {
        Map<String,Container> children = getChildren();
        for (Map.Entry child : children.entrySet()) {
            if (child.getValue() instanceof Host) {
                return ((Host) child.getValue());
            }
        }
        return null;
    }

}
