// 귤 고르기
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i : tangerine){
            if(hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            }
            else {
                hm.put(i, 1);
            }
        }
        List<Integer> values = new ArrayList<>(hm.values());
        values.sort(Comparator.reverseOrder());
        
        for(int i : values){
            if(i >= k) { 
                return answer;
            }
            k -= i;
            answer++;
        }
        return answer;
    }
}