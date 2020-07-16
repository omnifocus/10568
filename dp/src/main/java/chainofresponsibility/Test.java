package chainofresponsibility;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 9:14 PM
 * @Description: chainofresponsibility
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String msg = "<a>haha,天朝</a>:)";

        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter()).addFilter(new CharacterEmotionFilter());
        System.out.println(new Text(msg, fc).getMsg());
    }
}
