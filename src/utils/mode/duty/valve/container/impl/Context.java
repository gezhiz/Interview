package utils.mode.duty.valve.container.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.ContainerBase;
import utils.mode.duty.valve.domain.DutyBean;

import java.util.Map;

/**
 *
 * Created by gezz on 2017/9/5.
 */
public class Context extends ContainerBase implements Container {

    public Wrapper mapper(DutyBean dutyBean) {
        Map<String,Container> children = getChildren();
        for (Map.Entry child : children.entrySet()) {
            if (child.getValue() instanceof Wrapper) {
                //简单起见，此处直接使用了Engine的孩子container中的Wrapper，
                // 一般来说，需要根据dutyBean对象的结果判定选择哪个Wrapper
                return ((Wrapper) child.getValue());
            }
        }
        return null;
    }

}
