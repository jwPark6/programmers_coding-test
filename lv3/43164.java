// 여행 경로

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    boolean[] visit;
    String[][] ts;
    boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        ts = tickets;
        int count = tickets.length;
        visit = new boolean[count];
        String start = "ICN";
        
        Arrays.sort(ts, (o1, o2) -> {
            if (o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        
        answer.add(start);
        dfs(start, count, answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public void dfs(String start, int count, List<String> answer) {
        if (count == 0) {
            flag = true;
            return;
        }
        
        for (int i = 0; i < visit.length; i++) {
            if (start.equals(ts[i][0]) && !visit[i]) {
                visit[i] = true;
                
                answer.add(ts[i][1]);
                dfs(ts[i][1], count - 1, answer);
                if (flag) return;
                visit[i] = false;
            }
        }
        answer.remove(answer.size() - 1);
    }
}