//카펫

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int x = sum/3;
        int y = 3;
        while(true){
            if((x-2)*(y-2) == yellow){
                answer[0] = x;
                answer[1] = y;
                break;
            }
            while(true){
                y++;
               if(sum%y==0){
                x = sum/y;
                break;
                } 
            }
            
        }
        return answer;
    }
}