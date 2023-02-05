// 가장 큰 수

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] ns = new String[numbers.length];
        String answer = "";
        
        for(int i = 0 ; i < numbers.length; i++) {
            ns[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(ns, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2); 
            }
        });
    
        for(String s : ns) {
            answer += s;
        }
        
        if(answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}