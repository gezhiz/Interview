package utils.mode.duty.basic;

/**
 * Created by gezz on 2017/9/1.
 */
public class DutyHandler3 extends DutyHandlerBase implements DutyHandler {

    public DutyHandler3() {
        super();
    }

    public DutyHandler3(DutyHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public void handle(DutyBean dutyBean) {
        System.out.println("dutyBean3 has bean called !");
        getBasicHandler().handle(dutyBean);
    }

}
