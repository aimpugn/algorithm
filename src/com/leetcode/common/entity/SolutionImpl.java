package com.leetcode.common.entity;

import sun.reflect.ReflectionFactory;

public class SolutionImpl implements SolutionInterface {

    @Override
    public void doTest() {
        Class<?> enclosingClass = getClass().getEnclosingClass();
        String className = "";
        if (enclosingClass != null) {
            className = enclosingClass.getName();
        } else {
            className = getClass().getName();
        }
        System.out.println(fixedSizeString(30, "test", "=") + String.format(" <%s> ", className) + fixedSizeString(-30, "start", "="));
        test();
        System.out.println(fixedSizeString(30, "test", "=") + String.format(" <%s> ", className) + fixedSizeString(-30, "done", "="));
    }

    /**
     * https://stackoverflow.com/a/13475390
     * @param length
     * @param content
     * @param repeater
     * @return
     */
    private String fixedSizeString(int length, String content, String repeater) {
        return String.format("%1$" + length + "s", content).replace(" ", repeater);
    }

    protected void test() {
        System.out.println(getClass().getName());
    }
}
