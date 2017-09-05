package utils.mode.duty.basic.test;

import org.junit.Test;
import utils.mode.duty.basic.DutyBean;
import utils.mode.duty.basic.DutyHandler1;
import utils.mode.duty.basic.DutyHandler2;
import utils.mode.duty.basic.DutyHandler3;

/**
 * Created by gezz on 2017/9/1.
 */
public class DutyHandlerTest {

    @Test
    public void testHandler() {
        DutyHandler1 dutyHandler1 = new DutyHandler1();
        DutyHandler2 dutyHandler2 = new DutyHandler2();
        dutyHandler2.setBasicHandler(dutyHandler1);
        DutyHandler3 dutyHandler3 = new DutyHandler3();
        dutyHandler3.setBasicHandler(dutyHandler2);
        dutyHandler3.handle(new DutyBean("type1"));
    }
}
