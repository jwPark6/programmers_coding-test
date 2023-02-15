// 메뉴 리뉴얼

import java.lang.StringBuilder;
import java.util.*;

class Solution {
    HashMap<String, Integer> hm = new HashMap<>();   
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        char[] cs;
        
        for(int c : course) {
            for (String s : orders) {
                cs = s.toCharArray();
                Arrays.sort(cs);
                comb(0, c, cs, new StringBuilder());       
            }
            
            List<Map.Entry<String, Integer>> entryset = new LinkedList<>(hm.entrySet());
			entryset.sort(((o1,o2)-> hm.get(o2.getKey()) - hm.get(o1.getKey())));
            
            int max = 2;
            for(Map.Entry<String, Integer> entry: entryset) {
				if(entry.getValue() >= max) {
					answer.add(entry.getKey());
					max = entry.getValue();
				}
			}
            
            hm.clear();
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public void comb(int start, int r, char[] s, StringBuilder sb) {
        if(r == 0) {
            hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i = start; i < s.length; i++) {
            sb.append(s[i]);
            comb(i + 1, r - 1, s, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}