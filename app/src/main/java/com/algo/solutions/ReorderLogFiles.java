package com.algo.solutions;

import com.algo.common.entity.SolutionImpl;

import java.util.Arrays;
import java.util.TreeMap;

public class ReorderLogFiles extends SolutionImpl {

    /**
     * <ol>
     *     <li>로그 가장 앞 부분은 식별자</li>
     *     <li>문자로 구성된 로그 우선, 숫자 로그는 그 다음</li>
     *     <li>식별자는 순서 영향 X, 문자 동일? 식별자 순</li>
     *     <li>숫자 로그는 입력 순서</li>
     * </ol>
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        String[] answer = new String[logs.length];
        String[] digits = new String[logs.length];
        TreeMap<String, TreeMap<String, String>> letters = new TreeMap<>();
        int answerIdx = 0;
        int digitsIdx = 0;
        for (String log : logs) {
            String logDetail = log.substring(log.indexOf(' ') + 1);
            char criteria = logDetail.charAt(0);
            // 0 = 48, 9 = 57 | A = 65, Z = 90 | a = 97, z = 122
            if (48 <= criteria && criteria <= 57) {
                digits[digitsIdx++] = log;
                continue;
            }
            // logDetail 간의 길이가 다르고, id가 뒤에 붙으면서 id가 순서에 영향을 주게 된다
            if (letters.containsKey(logDetail)) {
                letters.get(logDetail).put(log, log);
                continue;
            }
            TreeMap<String, String> subLetters = new TreeMap<>();
            subLetters.put(log, log);
            letters.put(logDetail, subLetters);
        }

        for (TreeMap<String, String> subLetters : letters.values()) {
            for (String subLetter : subLetters.values()) {
                answer[answerIdx++] = subLetter;
            }
        }
        for (int i = 0; i < digitsIdx; i++) {
            answer[answerIdx++] = digits[i];
        }

        return answer;
    }

    @Override
    protected void test() {
        /*System.out.println(Arrays.toString(reorderLogFiles(
                new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}
                //          ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        )));
        System.out.println(Arrays.toString(reorderLogFiles(
                new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})
                //          ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
        ));*/
        /*System.out.println(Arrays.toString(reorderLogFiles(
                new String[]{"t kvr", "r 3 1", "i 403", "7 so", "t 54"})
                //          ["t kvr","7 so","r 3 1","i 403","t 54"]
        ));*/
        System.out.println(Arrays.toString(reorderLogFiles(
                new String[]{"dig1 8 1 5 1","let1 art zero can","dig2 3 6","let2 own kit dig","let3 art zero"})
                //   Output ["let1 art zero can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
                // Expected ["let3 art zero","let1 art zero can","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        ));

        System.out.printf("%d\n", "def".chars().reduce(0, Integer::sum));
        System.out.printf("%d\n", "abcd".chars().reduce(0, Integer::sum));
    }

    public String[] reorderLogFiles2(String[] logs) {
        int insert_pt = logs.length - 1; // where to put the next digit logs
        while (insert_pt >= 0 && Character.isDigit(logs[insert_pt].charAt(logs[insert_pt].length() - 1))) --insert_pt;
        for (int i = insert_pt; i >= 0; --i) {
            String str = logs[i];
            if (Character.isDigit(str.charAt(str.length() - 1))) {
                String temp = logs[insert_pt];
                logs[insert_pt] = logs[i];
                logs[i] = temp;
                --insert_pt;
            }
        }

        Arrays.sort(logs, 0, insert_pt + 1, (x,y)->{
            int start_x = 0;
            while (x.charAt(start_x++) != ' ');
            int start_y = 0;
            while (y.charAt(start_y++) != ' ');
            for (; start_x < x.length() && start_y < y.length(); ++start_x, ++start_y) {
                int comp = Character.compare(x.charAt(start_x), y.charAt(start_y));
                if (comp != 0) return comp;
            }

            if (start_x == x.length() && start_y == y.length()) {
                return x.compareTo(y);
            } else return start_x < x.length() ? 1 : -1;
        });

        return logs;
    }
}
