package utils.mode.duty.basic;

/**
 * Created by gezz on 2017/9/1.
 */
public class DutyHandler2 extends DutyHandlerBase implements DutyHandler {

    public DutyHandler2() {
        super();
    }

    public DutyHandler2(DutyHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public void handle(DutyBean dutyBean) {
        System.out.println("dutyBean2 has bean called !");
        getBasicHandler().handle(dutyBean);
    }

}
