package chainofresponsibility;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:15 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public interface Filter {
    String doFilter(String msg);
}
