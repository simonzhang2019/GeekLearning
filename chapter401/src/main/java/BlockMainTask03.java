import java.util.concurrent.CountDownLatch;

public class BlockMainTask03 {

    /**
     * 方法三：使用CountDownLatch
     */
    public static void main(String[] args) throws Exception {
        System.out.println("主线程工作开始：" + System.currentTimeMillis());

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(new SubTask(countDownLatch));
        thread.start();
        countDownLatch.await();
        System.out.println("主线程工作结束：" + System.currentTimeMillis());

    }

    public static class SubTask implements Runnable {
        private CountDownLatch latch;

        public SubTask(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            System.out.println("子线程工作开始：" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("子线程工作结束：" + System.currentTimeMillis());
                latch.countDown();
            }
        }
    }
}

