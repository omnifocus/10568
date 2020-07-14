package chainofresponsibility.reqresp;

import chainofresponsibility.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:36 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class FilterChain implements WebFilter {
    private List<WebFilter> filters = new ArrayList<>();
    private int step;

    //链式编程
    public FilterChain addFilter(WebFilter filter) {
        filters.add(filter);
        return this;
    }


    @Override
    public void doFilter(Request req, Response rep, FilterChain chain) {
        if (step >= filters.size()) return;
        filters.get(step++).doFilter(req, rep, chain);
    }
}
