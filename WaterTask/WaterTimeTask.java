package com.Mondo.demo.WaterTask;



import com.Mondo.demo.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import static com.Mondo.demo.util.ThreadUtil.*;


public class WaterTimeTask extends TimerTask{
    @Override
    public void run() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10000);
        InputThread  thread1 = new InputThread(queue);
        OutputThread thread2 = new OutputThread(queue);
        List<Callable<Object>> threadList = new ArrayList<>(2);  //集合大小表示线程的数量
        threadList.add(thread1);
        threadList.add(thread2);
        List<Object> returnValue = null;
        try {
            returnValue = runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("泳池已经注满！");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
    }
}

