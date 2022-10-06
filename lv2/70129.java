//이진변환 반복하기

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int countZero = 0;
        int countChange = 0;
        
        while(!s.equals("1")){
            countZero += s.length() - s.replaceAll("0", "").length();
            s = s.replaceAll("0", "");
            countChange++;
            s = Integer.toBinaryString(s.length());
        }
        answer = new int[]{countChange, countZero};
        return answer;
    }  
}