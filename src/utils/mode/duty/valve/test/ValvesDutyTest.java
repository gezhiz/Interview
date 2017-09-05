package utils.mode.duty.valve.test;

import org.junit.Test;
import utils.mode.duty.valve.container.impl.Engine;
import utils.mode.duty.valve.container.impl.Host;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.impl.StandardEngineValve;
import utils.mode.duty.valve.valves.impl.StandardHostValve;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.valves.ValveContext;

/**
 * 责任链测试入口
 * Created by gezz on 2017/9/5.
 */
public class ValvesDutyTest {
    @Test
    public void test() {
        Engine engine = new Engine();
        engine.setName("engine");
        //添加阀门(Valve)，可以添加多个普通阀门，所有的阀门都有机会得到执行，也可以根据dutyBean对象选择不执行
        engine.addValve(new Valve() {
            @Override
            public void invoke(DutyBean dutyBean, ValveContext context) {
                System.out.println("normal engine valve executed !");
                context.invokeNext(dutyBean);
            }
        });
        //每一个Container对象都必须要添加一个BasicValve，基本阀门的invoke选择性的选取孩子Container执行其invoke方法，让责任链继续往下执行
        engine.setBasicValve(new StandardEngineValve());
        Host host = new Host();
        host.setName("host");
        //添加阀门(Valve)，可以添加多个普通阀门，所有的阀门都有机会得到执行，也可以根据dutyBean对象选择不执行
        host.addValve(new Valve() {
            @Override
            public void invoke(DutyBean dutyBean, ValveContext context) {
                System.out.println("host engine valve executed !");
                context.invokeNext(dutyBean);
            }
        });
        host.setBasicValve(new StandardHostValve());//每一个Container对象都必须要添加一个BasicValve
        engine.addChild(host);
        engine.invoke(new DutyBean("valveType"));
    }
}
