package utils.mode.duty.valve.domain;

/**
 * Created by gezz on 2017/9/5.
 */
public class Servlet {
    private Request request;
    private Response response;

    public void service(Request request, Response response) {
        System.out.println("Servlet service executed !");
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
