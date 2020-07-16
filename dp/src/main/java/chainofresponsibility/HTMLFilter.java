package chainofresponsibility;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:17 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class HTMLFilter implements Filter {


    @Override
    public String doFilter(String msg) {
        return msg.replace("<", "[").replace(">", "]");
    }
}
