package service;

import net.sourceforge.groboutils.junit.v1.TestRunnable;

public class Thread1 extends Thread{
    private Sum sum;

    public Thread1(Sum sum) {
        this.sum = sum;
    }

    public Thread1(Sum sum,String name) {
        super(name);
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            sum.jian();
        }
    }
}
