// 롤케이크 자르기

import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        int answer = 0;
        boolean check = false;
        int temp = 0;
        
        for(int i = 0; i < topping.length; i++) {
            temp = topping[i];
            hm1.put(temp, hm1.getOrDefault(temp, 0) + 1);
        }
        
        for(int i = 0; i < topping.length - 1; i++) {
            temp = topping[i];
            hm2.put(temp, hm2.getOrDefault(temp, 0) + 1);
            //hm1.put(temp, hm1.get(temp) - 1);
            
            if(hm1.get(temp).equals(hm2.get(temp))) {
                hm1.remove(temp);
            }
            
            if(hm1.size() == hm2.size()) {
                answer++;
                check = true;
            } else if (check) break;
        }
        
        return answer;
    }
}