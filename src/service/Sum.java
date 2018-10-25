package service;

public class Sum {
    private Integer index=0;

    public synchronized void   jian(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"开始执行了-----");
        index++;
        System.out.println(index);
    }
}
