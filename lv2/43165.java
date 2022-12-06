import java.util.Arrays;

class Solution {
    int answer = 0;
    int target = 0;
    
    public int solution(int[] numbers, int target) {
        this.target = target; 
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int sum, int count){
        if(count == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers, sum + numbers[count], count+1);
        dfs(numbers, sum - numbers[count], count+1);
    }
}