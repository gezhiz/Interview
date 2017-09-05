package utils.mode.duty.basic;

/**
 * Created by gezz on 2017/9/1.
 */
public abstract class DutyHandlerBase implements DutyHandler {

    private DutyHandler basicHandler;

    public DutyHandlerBase() {
    }

    public DutyHandlerBase(DutyHandler basicHandler) {
        this.basicHandler = basicHandler;
    }

    @Override
    public abstract void handle(DutyBean dutyBean);

    public DutyHandler getBasicHandler() {
        return basicHandler;
    }

    public void setBasicHandler(DutyHandler basicHandler) {
        this.basicHandler = basicHandler;
    }
}
