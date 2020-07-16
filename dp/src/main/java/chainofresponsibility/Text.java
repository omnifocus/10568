package chainofresponsibility;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:16 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class Text {
    private String msg;
    private FilterChain fc;

    public Text(String msg, FilterChain fc) {
        this.msg = msg;
        this.fc = fc;
    }

    public String getMsg() {
        return fc.doFilter(msg);
    }
}
