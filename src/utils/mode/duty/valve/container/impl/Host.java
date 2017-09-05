package utils.mode.duty.valve.container.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.ContainerBase;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.Pipeline;

import java.util.Map;

/**
 * Created by gezz on 2017/9/5.
 */
public class Host extends ContainerBase implements Container, Pipeline {

    /**
     * 根据dutyBean匹配一个Context对象
     * @param dutyBean
     * @return
     */
    public Context mapper(DutyBean dutyBean) {
        Map<String,Container> children = getChildren();
        for (Map.Entry child : children.entrySet()) {
            if (child.getValue() instanceof Context) {
                //简单起见，此处直接使用了Engine的孩子container中的Context，
                // 一般来说，需要根据dutyBean对象的结果判定选择哪个Context
                return ((Context) child.getValue());
            }
        }
        return null;
    }

}
