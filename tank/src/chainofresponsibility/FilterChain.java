package chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:36 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();

    //链式编程
    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public String doFilter(String msg) {
        for (int i = 0; i < filters.size(); i++) {
            msg = filters.get(i).doFilter(msg);
        }
        return msg;
    }
}
