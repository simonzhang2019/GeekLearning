import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class BlockMainTask04 {

    /**
     * 方法四：使用CyclicBarrier
     */
    public static void main(String[] args) throws Exception {
        System.out.println("主线程工作开始：" + System.currentTimeMillis());

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            public void run() {
                System.out.println("主线程工作结束：" + System.currentTimeMillis());
            }
        });

        Thread thread = new Thread(new SubTask(cyclicBarrier));
        thread.start();
    }

    public static class SubTask implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public SubTask(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {
            System.out.println("子线程工作开始：" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
                System.out.println("子线程工作结束：" + System.currentTimeMillis());
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

