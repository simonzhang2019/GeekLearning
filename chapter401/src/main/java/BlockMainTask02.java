public class BlockMainTask02 {

    /**
     * 方法二：主线程调用子线程的Join方法
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程工作开始：" + System.currentTimeMillis());

        Runnable subtask = new Runnable() {
            public void run() {
                System.out.println("子线程工作开始：" + System.currentTimeMillis());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("子线程工作结束：" + System.currentTimeMillis());
                }
            }
        };

        Thread thread = new Thread(subtask);
        thread.start();
        thread.join();
        System.out.println("主线程工作结束：" + System.currentTimeMillis());

    }
}

