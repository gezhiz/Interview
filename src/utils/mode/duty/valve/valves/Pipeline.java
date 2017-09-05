package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * 责任链核心接口，每一个责任节点都必须有一个Pipeline对象，
 * 每个Pipeline可以对象拥有多个normal阀门，必须拥有一个基础阀门
 * Created by gezz on 2017/9/1.
 */
public interface Pipeline {
    void invoke(DutyBean dutyBean);//核心方法
    void addValve(Valve valve);//为责任链节点添加阀门
    Valve[] getValves();//获取所有的阀门
    void removeValve(Valve valve);//删除一个阀门
    void setBasicValve(Valve basicValve);//设置基础阀门
}
