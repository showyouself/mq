import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * 通过Future配合Callable可以获取线程执行的结果，并且可以阻塞获取
 */
public class FutureTest {
     
    ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Test
    public void test() throws  Exception{
        Future<Integer> a = calculate(100);

        /**
         * 使用isDone()方法判断是否执行结束
         */
        while (!a.isDone()){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("线程执行中");
            /**
             * 可以使用cancel取消线程执行
             * 同时使用a.isCancelled()查看取消结果
             */
//            a.cancel(true);
//            System.out.println(a.isCancelled());
        }
        /**
         * 使用get()方法获取结果，该方法是阻塞的
         *
         *  也可以设置超时间5s ：a.get(5, TimeUnit.SECONDS);
         */
        System.out.println("线程执行结果" + a.get());

    }

    /**
     * 抛出线程，返回Future类
     * @param input
     * @return
     */
    public Future<Integer> calculate(Integer input) {
        return executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                return input * input;
            }
        });
    }
}