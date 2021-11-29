package com.algo.common.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorHelper {
    private ArrayList<Runnable> targetList = new ArrayList<>();

    public void setTargetList(Runnable... targetList) {
        this.targetList.addAll(Arrays.asList(targetList));
    }

    public void start() {
        if (! this.targetList.isEmpty()) {
            ExecutorService service = Executors.newFixedThreadPool(this.targetList.size());
            for (Runnable target : this.targetList) {
                service.execute(target);
            }
            service.shutdown();
        }
    }
}
