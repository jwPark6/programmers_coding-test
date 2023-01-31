// 할인 행사

import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        HashMap<String, Integer> tm;
        int answer = 0;
        int length = discount.length;
        int count = 0;
        int idx = 0;
        
        for(int i = 0; i < want.length; i++) {
            hm.put(want[i], number[i]);
        }
        
        while(idx <= length - 10){
            tm = (HashMap<String, Integer>) hm.clone();
            
            for(int i = idx; i < idx + 10; i++) {
                if (count != i - idx) break;
                
                String s = discount[i];
                
                if(tm.containsKey(s)) {
                    int value = tm.get(s);
                    
                    if (value > 0) {
                        tm.replace(s, value - 1);
                        count++;
                    } 
                } else break;  
            }
            if (count == 10) answer++;
            idx++;
            count = 0;
        }
        return answer;
    }
}