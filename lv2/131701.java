// 연속 부분 수열 합의 개수
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> result = new HashSet<Integer>();
        int len = elements.length;
        int sum = 0;
        
        for(int i = 0; i < len; i++) {
            sum += elements[i];
        }
        result.add(sum);
        
        for(int i = 0; i < len; i++) {
            sum = elements[i];
            result.add(sum);
            
            for(int j = 1; j < len - 1; j++){
                sum += elements[(i + j) % len];
                result.add(sum);
            }
        }
        
        return result.size();
    }
}