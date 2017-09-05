package utils.mode.duty.valve.domain;

/**
 * Created by gezz on 2017/9/1.
 */
public class DutyBean {
    private String type;
    private Request request;
    private Response response;


    public DutyBean(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
