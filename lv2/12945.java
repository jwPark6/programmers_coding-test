//피보나치 수

class Solution {
    public int solution(int n) {
        int answer = fib(n, 0, 1);
        return answer;
    }
    
    public int fib(int n, int prevprevResult, int prevResult){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return prevResult;
        }
        else{
            return fib(n-1, prevResult, (prevprevResult + prevResult)%1234567);
        }
    }
}