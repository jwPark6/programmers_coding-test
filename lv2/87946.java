class Solution {
    int answer = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        rec(k, 0, dungeons);
        return answer;
    }
    
    public void rec(int k, int idx, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                rec(k-dungeons[i][1], idx++, dungeons);
                visit[i] = false;
            }
        }    
        answer = Math.max(answer, idx);
    }
}