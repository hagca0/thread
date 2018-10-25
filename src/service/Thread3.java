package service;

import java.util.concurrent.Callable;

public class Thread3 implements Callable{
    private Sum sum;

    public Thread3(Sum sum) {
        this.sum = sum;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 100; i++) {
           sum.jian();
        }
        return 100;
    }
}
