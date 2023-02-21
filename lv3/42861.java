// 섬 연결하기

import java.util.Arrays;

class Solution {   
    int[] uf;
        
    public int solution(int n, int[][] costs) {
        int answer = 0;
        uf = new int[n];
        int n1 = 0;
        int n2 = 0;
        
        for(int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });
        
        for (int[] is : costs) {
            n1 = find(is[0]);
            n2 = find(is[1]);
            
            if (n1 != n2) {            
                uf[n2] = n1;
                answer += is[2];
            }    
        }

        return answer;
    }
    
    public int find(int a) {
        while (a != uf[a]) a = uf[a];

        return a;
    }
}