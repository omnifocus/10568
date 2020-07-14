package chainofresponsibility.reqresp;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:10 PM
 * @Description: chainofresponsibility.reqresp
 * @version: 1.0
 */
public class HTMLWebFilter implements WebFilter {
    @Override
    public void doFilter(Request req, Response rep, FilterChain chain) {
        if (req.reqStr.contains("<")) {
            return;
        }
        req.reqStr = req.reqStr.replace("<", "[").replace(">", "]");
        System.out.println("HTMLWebFilter.doFilter");
        chain.doFilter(req, rep, chain);
        rep.respStr = rep.respStr.replace("<", "[").replace(">", "]");
        System.out.println("HTMLWebFilter.doFilter");
    }
}
