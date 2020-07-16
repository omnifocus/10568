package thread;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 11:43 PM
 * @Description: thread
 * two synchronized methods have no influence ??
 * @version: 1.0
 */
public class TT implements Runnable {
    int b = 100;

    public synchronized void m1() throws InterruptedException {
        b = 1000;
//        Thread.sleep(1000);
        System.out.println("b = " + b);
    }

    public synchronized void m2() throws InterruptedException {

        Thread.sleep(10);
        b = 2000;
    }


    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {


        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();

        tt.m2();
        System.out.println(tt.b);
    }
}
