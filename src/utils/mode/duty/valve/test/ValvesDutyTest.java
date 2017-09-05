package utils.mode.duty.valve.test;

import org.junit.Test;
import utils.mode.duty.valve.container.Engine;
import utils.mode.duty.valve.container.Host;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.valves.StandardEngineValve;
import utils.mode.duty.valve.valves.StandardHostValve;
import utils.mode.duty.valve.valves.Valve;
import utils.mode.duty.valve.valves.ValveContext;

/**
 * Created by gezz on 2017/9/5.
 */
public class ValvesDutyTest {
    @Test
    public void test() {
        Engine engine = new Engine();
        engine.setName("engine");
        engine.addValve(new Valve() {
            @Override
            public void invoke(DutyBean dutyBean, ValveContext context) {
                System.out.println("normal engine valve executed !");
                context.invokeNext(dutyBean);
            }
        });
        engine.setBasicValve(new StandardEngineValve());
        Host host = new Host();
        host.setName("host");
        host.addValve(new Valve() {
            @Override
            public void invoke(DutyBean dutyBean, ValveContext context) {
                System.out.println("host engine valve executed !");
                context.invokeNext(dutyBean);
            }
        });
        host.setBasicValve(new StandardHostValve());
        engine.addChild(host);
        engine.invoke(new DutyBean("valveType"));
    }
}
