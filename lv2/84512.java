// 모음 사전
class Solution {
    public int solution(String word) {
        String temp = "AEIOU";
        int[] value = {781, 156, 31, 6, 1};
        int answer = word.length();
        
        for(int i = 0; i < word.length(); i++){
            int num = temp.indexOf(word.charAt(i));
            answer += value[i] * num;
        }
        
        return answer;
    }
}