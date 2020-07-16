package chainofresponsibility.reqresp;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:09 PM
 * @Description: chainofresponsibility.reqresp
 * @version: 1.0
 */
public interface WebFilter {
    void doFilter(Request req, Response rep, FilterChain chain);
}
