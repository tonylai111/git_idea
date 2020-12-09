import java.util.concurrent.*;

public class ThreadPoolDemo {
    private static Integer corePoolSize = 2;
    private static Integer maximumPoolSize = 5;
    private static Long keepAliveTime = 1L;
    public static void main(String[] args) {
        // public ThreadPoolExecutor(int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue,
        //                              ThreadFactory threadFactory,
        //                              RejectedExecutionHandler handler) {

        //这里我们模拟使用带5个参数的方法
        ExecutorService threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory()
        );
        try {
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 给第"+tempInt+"个用户办理业务了");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
