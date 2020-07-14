package chainofresponsibility.reqresp;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:16 PM
 * @Description: chainofresponsibility.reqresp
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        FilterChain fc = new FilterChain();
        fc.addFilter(new CharacterEmotionWebFilter()).addFilter(new SensitiveWebFilter()).addFilter(new HTMLWebFilter());
        Request req = new Request();
        req.reqStr = "<a>天朝:)</a>";
        Response rep = new Response();
        rep.respStr = "<b>屁民们迎油价上涨:D";
        fc.doFilter(req, rep, fc);
        System.out.println("--------");
        System.out.println(req.reqStr);
        System.out.println(rep.respStr);
    }
}
