// 소수 찾기

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<Integer>();
    String[] ss;
    boolean[] check;
    
    public int solution(String numbers) {
        int answer = 0;
        ss = numbers.split("");
        check = new boolean[ss.length];
        
        es("");
        
        for(int i : set) {
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    public void es(String sum) {                  
        for(int i = 0; i < ss.length; i++) {
            if(check[i]) continue;
            
            check[i] = true;
            set.add(Integer.parseInt(sum + ss[i]));
            es(sum + ss[i]);
            check[i] = false;
        }
    }
    
    public boolean isPrime(int i) {
        if (i == 2) return true;
        if (i < 2) return false;
        
        for(int j = 2; j*j <= i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}