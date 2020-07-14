package chainofresponsibility.reqresp;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:12 PM
 * @Description: chainofresponsibility.reqresp
 * @version: 1.0
 */
public class SensitiveWebFilter implements WebFilter {


    @Override
    public void doFilter(Request req, Response rep, FilterChain chain) {

        req.reqStr = req.reqStr.replace("天朝", "中国").replace("迎", "喜迎");
        System.out.println("SensitiveWebFilter.doFilter");
        chain.doFilter(req, rep, chain);
        rep.respStr = rep.respStr.replace("天朝", "中国").replace("迎", "喜迎");
        ;
        System.out.println("SensitiveWebFilter.doFilter");
    }
}
