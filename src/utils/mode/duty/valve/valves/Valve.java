package utils.mode.duty.valve.valves;

import utils.mode.duty.valve.domain.DutyBean;

/**
 * 阀门
 * 每个责任链节点（Pipeline）都有多个阀门，
 * 普通阀门：负责处理当前责任链节点的业务具体业务
 * 基础阀门的额外功能：处理业务，负责将责任链处理的结果传给下一个责任链节点
 * Created by gezz on 2017/9/5.
 */
public interface Valve {
    void invoke(DutyBean dutyBean, ValveContext context);
}
