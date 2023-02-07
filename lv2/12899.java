// 124 나라의 숫자

class Solution {
    public String solution(int n) {
        String[] otf = {"1", "2", "4"};
        String answer = "";
        
        while(true) {
            n--;
            answer = otf[n % 3] + answer;
            
            if(n / 3 == 0) break;
            
            n /= 3;
        }
        
        return answer;
    }
}