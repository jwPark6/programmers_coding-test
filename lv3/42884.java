// 단속 카메라

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int temp = 0;
        boolean[] check = new boolean[routes.length];
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for(int i = 0; i < routes.length; i++) {
            if (check[i]) continue;
            temp = routes[i][1];
            answer++;
            for(int j = i; j < routes.length; j++) {
                if (!check[j] && routes[j][0] <= temp) {
                    check[j] = true;
                }
            }
        }
        
        return answer;
    }
}