package utils.mode.duty.basic;

/**
 * Created by gezz on 2017/9/1.
 */
public class DutyHandler1 extends DutyHandlerBase implements DutyHandler {

    public DutyHandler1() {
        super();
    }

    public DutyHandler1(DutyHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public void handle(DutyBean dutyBean) {
        System.out.println("dutyBean1 has bean called !");
    }

}
