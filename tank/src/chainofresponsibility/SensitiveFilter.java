package chainofresponsibility;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:22 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class SensitiveFilter implements Filter {

    @Override
    public String doFilter(String msg) {
        return msg.replace("天朝", "china");
    }
}
