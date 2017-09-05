package utils.mode.duty.valve.container.impl;

import utils.mode.duty.valve.container.Container;
import utils.mode.duty.valve.container.ContainerBase;
import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.domain.Servlet;
import utils.mode.duty.valve.pipline.Pipeline;

/**
 * 最底层容器，在Tomcat4里面用Wrapper包装servlet,用invoke调用servlet对象的service方法
 * Created by gezz on 2017/9/5.
 */
public class Wrapper extends ContainerBase implements Container, Pipeline {
    private Servlet servlet;

    public Wrapper(Servlet servlet) {
        this.servlet = servlet;
    }

    @Override
    public void invoke(DutyBean dutyBean) {
        super.invoke(dutyBean);
    }

    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
