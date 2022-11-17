import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 1
        int answer = 0;
        int length = citations.length;
        
        for(int i=0; i < citations.length; i++, length--){ // 2
            if(citations[i] >= length){ // 3
                answer = citations[i];
                break;
            }
        }
        
        while(true){ // 4
            if(answer <= length){
                return answer;
            }
            answer--;
        }
    }
}