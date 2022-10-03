class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = n/2; i>0; i--){
            int startNum = i;
            int remainNum = n-startNum;
            while(true){
                remainNum -= ++startNum;
                if(remainNum < 0){
                    break;
                }
                if(remainNum == 0){
                    answer++;
                    break;
              }
            }
            
        }
        return answer;
    }
}