package com.bluestroy.concurrent;

/**
 * Created by Troy on 2016/9/17.
 */

/**
 * 生产者消费者问题，理解互斥与同步
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer producer = new Producer(ss);
        Consumer consumer = new Consumer(ss);
        new Thread(producer).start();
        new Thread(consumer).start();

        System.out.println("test");
    }
}

/**
 * 窝窝头商品
 */
class WoTou {
    int id;

    public WoTou(int id) {
        this.id = id;

    }

    public String toString() {
        return "WoTou " + id;
    }
}

/**
 * 生产者消费者锁操作
 */
class SyncStack {
    int index = 0;
    WoTou[] arrwt = new WoTou[6];

    public synchronized void push(WoTou wt) {
        //生产者
        while (index == arrwt.length - 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        arrwt[index++] = wt;
    }

    public synchronized WoTou pop() {
        //消费者
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrwt[index];
    }

}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    SyncStack ss = null;

    public Producer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生成了：" + wt);
            try {
                Thread.sleep((int) (50 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    SyncStack ss = null;

    public Consumer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = ss.pop();
            System.out.println("消费了：" + wt);
            try {
                Thread.sleep((int) (50 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
