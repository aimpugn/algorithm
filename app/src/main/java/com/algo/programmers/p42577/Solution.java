package com.algo.programmers.p42577;
/* https://programmers.co.kr/learn/courses/30/lessons/42577 */

import com.algo.common.entity.SolutionImpl;

import java.util.HashMap;

public class Solution extends SolutionImpl {
    /**
     * <pre>
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우
     * - 구조대 : 119
     * - 박준영 : 97 674 223
     * - 지영석 : 11 9552 4421
     * >> 구조대 전화번호 = 지영석 전화번호의 접두사
     * </pre>
     * @param phone_book 1 이상 1,000,000 이하, 각 전화번호의 길이는 1 이상 20 이하, 전화번호 중복 없음
     * @return 어떤 번호가 다른 번호 접두어인 경우 false, 아닌 경우 true
     */
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 전화번호부의 숫자로 가능한 접두어 체크 해시 맵을 만든다
        HashMap<String, Boolean> prefixChecker = new HashMap<>();
        for (String phoneNumber : phone_book) {
            phoneNumber = phoneNumber.trim();
            for (int end = 1; end < phoneNumber.length(); end++) { // 접두어가 되려면 적어도 끝에 문자 하나는 있어야 하므로, 전화번호 그대로는 체커에 넣지 않는다
                String prefixToCheck = phoneNumber.substring(0, end);
                if (! prefixChecker.containsKey(prefixToCheck)) {
                    prefixChecker.put(prefixToCheck, true);
                }
            }
        }

        for (String phoneNumber : phone_book) {
            if (prefixChecker.containsKey(phoneNumber)) {
                return false;
            }
        }

        return answer;
    }

    public boolean solution_1st_fail(String[] phone_book) {
        boolean answer = true;
        int phone_book_size = phone_book.length;

        for (int idx = 0; idx < phone_book_size; idx++) {
            phone_book[idx] = phone_book[idx].trim();
        }

        for (int from = 0; from < phone_book_size; from++) {
            for (int next = from + 1; next < phone_book_size; next++) {
                if (phone_book[next].trim().startsWith(phone_book[from].trim())) {
                    return false;
                }
            }
        }

        return answer;
    }


    @Override
    protected void test() {
        Solution solution = new Solution();
        System.out.printf("1. %b\n", solution.solution(new String[] {
                "119", "97674223", "1195524421"
        }));
//        System.out.printf("2. %b\n", solution.solution(new String[] {
//                "123","456","789"
//        }));
//        System.out.printf("2. %b\n", solution.solution(new String[] {
//                "12","123","1235","567","88"
//        }));
    }
}