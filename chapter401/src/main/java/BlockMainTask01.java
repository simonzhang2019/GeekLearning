public class BlockMainTask01 {

    /**
     * 方法一：主线程等待一个超过子线程运行所需时间的时间
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

        Thread.sleep(6000);
        System.out.println("主线程工作结束：" + System.currentTimeMillis());

    }
}

