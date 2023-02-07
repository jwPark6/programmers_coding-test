import java.lang.StringBuilder;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int maxIdx = 0;
        int endIdx = k;
        int compare = 0;
          
        while(sb.length() != number.length() - k) {
            for(int i = maxIdx; i <= endIdx; i++) {
                          
                if(max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    maxIdx = i;
                }
            }
            endIdx++;
            sb.append(number.charAt(maxIdx++));
            max = 0;
        }
        
        return sb.toString();
    }
}