package com.algo.programmers.p42576;
import java.util.HashMap;

/* https://programmers.co.kr/learn/courses/30/lessons/42576 */
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completionMap = new HashMap<>();
        for (String completer : completion) {
            if (completionMap.containsKey(completer)) {
                completionMap.put(completer, completionMap.get(completer) + 1);
                continue;
            }
            completionMap.put(completer, 1);
        }

        for (String participantName : participant) {
            if (! completionMap.containsKey(participantName)) {
                return participantName;
            }
            if (completionMap.get(participantName) == 1) {
                completionMap.remove(participantName);
                continue;
            }

            completionMap.put(participantName, completionMap.get(participantName) - 1);
        }


        return answer;
    }
}