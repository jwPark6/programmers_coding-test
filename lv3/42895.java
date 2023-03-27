// N으로 표현

import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {   
        int n = 0;
        HashSet<Integer>[] hs = new HashSet[9];
        
        for (int i = 1; i < 9; i++) {
            hs[i] = new HashSet<>();
        }
        
        for (int i = 1; i < 9; i++) {
            n = n * 10 + N;
            hs[i].add(n);
            
            for (int j = 1; j < i; j++) {
                for (int v : hs[j]) {
                    for (int w : hs[i - j]) {
                        if (w <= 0) continue;
                        hs[i].add(v + w);
                        hs[i].add(v - w);
                        hs[i].add(v * w);
                        hs[i].add(v / w);
                    }
                }
            }
            
            if (hs[i].contains(number)) return i;
        }
        
        return -1;
    }
}