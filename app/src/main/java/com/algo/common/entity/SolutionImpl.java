package com.algo.common.entity;

import java.util.Objects;

public class SolutionImpl implements SolutionInterface {

    @Override
    public void doTest() {
        Class<?> enclosingClass = getClass().getEnclosingClass();
        String className;
        className = Objects.requireNonNullElseGet(enclosingClass, this::getClass).getName();
        System.out.println(fixedSizeString(30, "test", "=") + String.format(" <%s> ", className) + fixedSizeString(-30, "start", "="));
        test();
        System.out.println(fixedSizeString(30, "test", "=") + String.format(" <%s> ", className) + fixedSizeString(-30, "done", "="));
    }

    /**
     * https://stackoverflow.com/a/13475390
     * @param length 전체 출력할 길이
     * @param content 자동 입력 외에 출력할 내용
     * @param repeater 어떤 문자로 채워 넣을 것인지
     * @return length 길이만큼 고정된 길이의 문자열
     */
    private String fixedSizeString(int length, String content, String repeater) {
        return String.format("%1$" + length + "s", content).replace(" ", repeater);
    }

    protected void test() {
        System.out.println("Please @Override it");
    }
}
