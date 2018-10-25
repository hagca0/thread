import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import service.Sum;
import service.Thread1;
import service.Thread2;
import service.Thread3;

import java.util.concurrent.*;

public class Test {
    @org.junit.Test
    public static void threeThread() throws Throwable {
        Sum sum=new Sum();
        Thread1 thread1=new Thread1(sum,"thread1");

        Thread  thread2=new Thread(new Thread2(sum),"thread2");

        Callable<Object> thread=new Thread3(sum);
        FutureTask<Object> future=new FutureTask<>(thread);
        Thread  thread3=new Thread(future,"thread3");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();

        /*TestRunnable[] testRunnables=new TestRunnable[3];
        testRunnables[0]=thread1;
        testRunnables[1]=thread1;
        testRunnables[2]=thread1;
        MultiThreadedTestRunner testRunner = new MultiThreadedTestRunner(testRunnables);
        testRunner.runTestRunnables();*/
    }

    public static void pool(){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Sum sum=new Sum();

        Thread1 thread1=new Thread1(sum,"thread1");

        Thread  thread2=new Thread(new Thread2(sum),"thread2");

        Callable<Object> thread=new Thread3(sum);
        FutureTask<Object> future=new FutureTask<>(thread);
        Thread  thread3=new Thread(future,"thread3");

        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.submit(thread3);
    }

    public static void poolFor(){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Sum sum=new Sum();
        for (int i = 0; i <1 ; i++) {
            executorService.submit(new Thread2(sum));
        }
    }

    public static void main(String[] args) {
        pool();
        //poolFor();
    }
}
