package chainofresponsibility;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:39 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class CharacterEmotionFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        msg = msg.replace(":)", "^_^");
        return msg;
    }
}
