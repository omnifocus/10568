package chainofresponsibility.reqresp;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:39 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class CharacterEmotionWebFilter implements WebFilter {


    @Override
    public void doFilter(Request req, Response rep, FilterChain chain) {
        req.reqStr = req.reqStr.replace(":)", "^_^").replace(":D", "O(∩_∩)O~ ");
        System.out.println("CharacterEmotionWebFilter.doFilter");
        chain.doFilter(req, rep, chain);
        rep.respStr = rep.respStr.replace(":)", "^_^").replace(":D", "O(∩_∩)O~ ");
        System.out.println("CharacterEmotionWebFilter.doFilter");
    }
}
