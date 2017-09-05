package utils.mode.duty.valve.container;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * 责任链的执行载体，容器
 * Created by gezz on 2017/9/1.
 */
public interface Container {
    void invoke(DutyBean dutyBean);
    void addChild(Container container);
    void setParent(Container container);
    Container getParent();
    String getName();
}
