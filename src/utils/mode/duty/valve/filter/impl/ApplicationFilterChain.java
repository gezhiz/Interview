package utils.mode.duty.valve.filter.impl;

import utils.mode.duty.valve.domain.DutyBean;
import utils.mode.duty.valve.domain.Servlet;
import utils.mode.duty.valve.filter.Filter;
import utils.mode.duty.valve.filter.FilterChain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by gezz on 2017/9/5.
 */
public final class ApplicationFilterChain implements FilterChain {
    private ArrayList<Filter> filters = new ArrayList<Filter>();
    private Iterator<Filter> iterator;
    private Servlet servlet;
    protected ApplicationFilterChain() {}

    @Override
    public void doFilter(DutyBean dutyBean) {
        if (iterator == null) {
            iterator = filters.iterator();
        }
        while(iterator.hasNext()) {
            Filter filter = iterator.next();
            //由filter决定是否要把过滤连给到下一个Filter,
            // 如果不给到下一个，则有链路调用下一个Filter,包括后续的servlet也得不到执行
            filter.doFilter(dutyBean,this);
            //如果前面有某个过滤器（例如filterA）不调用doFilter方法，则过滤链会在filterA的doFilter停止，
            // 过滤链会在第一个过滤器的doFilter方法执行完成后return，从而是的递归调用终止
            return;
        }
        //链路的最后一个Filter执行了doFilter之后，没有了更多的Filter,
        // 会跳出上面的while循环，然后会执行下面的代码，接着返回给上一个Filter，
        //最终回到第一个Filter的doFilter方法返回，然后在while循环中执行"return;",FilterChain的doFilter就运行结束了。
        if (servlet != null) {
            servlet.service(dutyBean.getRequest(),dutyBean.getResponse());
        }
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
