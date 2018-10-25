package service;

public class Thread2 implements Runnable{
    private Sum sum;

    public Thread2(Sum sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            sum.jian();
        }
    }
}
