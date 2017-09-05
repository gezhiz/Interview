package utils.mode.duty.valve.container.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.ContainerBase;
import utils.mode.duty.valve.pipline.Pipeline;
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
                //简单起见，此处直接使用了Engine的孩子container中的Host，
                // 一般来说，需要根据dutyBean对象的结果判定选择哪个Host
                return ((Host) child.getValue());
            }
        }
        return null;
    }
}
