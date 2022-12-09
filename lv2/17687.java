class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String num = "0";
        int count = 1;
        
        while(num.length() < t * m) {
            num += Integer.toString(count++, n);
        }
        String[] ss = num.toUpperCase().split("");
        
        for(int i = 0; i < ss.length; i++){
            if ((i % m) == p - 1) answer += ss[i];
            if (answer.length() == t) break;
        }
        
        return answer;
    }
}