import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; // 1
        
        Map<String, Integer> m = new HashMap();
        
        for(String[] ss : clothes){ // 2
            String s = ss[1];
            if(m.containsKey(s)){
                m.put(s, m.get(s) + 1);
            }
            else{
                m.put(s, 2);
            }
        }
        Collection<Integer> values = m.values(); // 3
        for(int i : values){
            answer *= i;
        }
        return answer - 1; // 4
    }
}