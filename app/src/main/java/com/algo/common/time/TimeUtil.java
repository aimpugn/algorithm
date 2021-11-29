package com.algo.common.time;

/**
 * https://www.techiedelight.com/measure-elapsed-time-execution-time-java/
 */
public class TimeUtil {
    private static long start;
    private static long end;

    public static long start() {
        TimeUtil.start = System.nanoTime();
        return TimeUtil.start;
    }

    public long getEnd() {
        return end;
    }

    public long getStart() {
        return start;
    }

    public void setEnd(long end) {
        TimeUtil.end = end;
    }

    public void setStart(long start) {
        TimeUtil.start = start;
    }

    public static void elapsedTime(boolean isMilliSeconds) {
        if(TimeUtil.start == 0) return;
        TimeUtil.end = System.nanoTime();
        /**
         * denominator: 분모
         */
        int denominator = isMilliSeconds ? 1000000 : 1;
        String message = isMilliSeconds ? "milliseconds" : "nanoseconds";
        System.out.println("Execution time in " + message + ": " + (TimeUtil.end - TimeUtil.start) / denominator);
    }
}
