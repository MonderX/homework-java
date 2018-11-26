package com.Mondo.demo.WaterTask;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class OutputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while (true){
            if (queue.size()==10000){
                break;
            }
            for (int cnt=0;cnt<3;cnt++){
                queue.poll(10, TimeUnit.SECONDS);
            }
            System.out.println("防水3立方米，当前水量："+queue.size());
            TimeUnit.SECONDS.sleep(1);

        }
        return "success";
    }

}
