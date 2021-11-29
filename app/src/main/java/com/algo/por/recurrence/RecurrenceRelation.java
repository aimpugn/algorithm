package com.algo.por.recurrence;

public class RecurrenceRelation {
    /**
     * # 재귀 함수 구현 전에 이해할 필요가 있는 두 가지
     * 1. Recurrence Relation
     * - 회귀 관계
     * - 문제의 결과와 하위 문제의 결과 사이의 관계
     * - 파스칼의 삼각형: f(i, j) = i번째 행과 j번째 열의 숫자 반환 = f(i - 1, j - 1) + f(i - 1, j)
     *  - f(1, 1) = 1, f(2, 1) = f(1, 0) + f(1, 1) = 1, f(2, 2) = f(1, 1) + f(1, 2) = 1 ...
     *
     * 2. base case
     * - 더이상 재귀 호출하지 않고 즉시 답을 계산할 수 있는 케이스
     * - 또한, 가장 작은 scale로 줄어들었기 때문에, 바닥 케이스(bottom case) 라고도 한다
     * - 파스칼의 삼각형: f(i, j) = 1
     *
     * 3. 중복 계산이 있을 수 있다
     */
}
