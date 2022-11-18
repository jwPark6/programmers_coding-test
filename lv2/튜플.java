import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", ""); // 1
        s = s.replaceAll("}", "");
        String[] cs = s.split(",");
        Map<Integer, Integer> m = new HashMap();
        
        for (String c : cs) { // 2
            int i = Integer.valueOf(c);
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }
        List<Integer> keys = new ArrayList<>(m.keySet()); // 3
        Collections.sort(keys, (v1, v2) -> (m.get(v2).compareTo(m.get(v1))));
        
        int[] is = new int[keys.size()]; // 4
        for (int i = 0; i < is.length; i++){
            is[i] = keys.get(i);
        }
        return is;
    }
}