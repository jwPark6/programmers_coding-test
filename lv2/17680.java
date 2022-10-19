// KAKAO 캐시

import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int count = 0;
        String str = null;
        if(cacheSize == 0) return cities.length*5;
        ArrayList<String> list = new ArrayList<>(cacheSize);
        
        for(int i=0; i<cities.length; i++){
            str = cities[i].toLowerCase();
            if(list.indexOf(str) != -1) {
                list.remove(list.indexOf(str));
                list.add(0, str);
                answer++;
            }
            else{
                list.add(0, str);
                if(count++ == cacheSize) list.remove(-1+count--);
                answer += 5;  
            }        
        }
        return answer;
    }
}