// 2 X N 타일링

class Solution {
    public int solution(int n) {
        int[] comb = new int[n];
        comb[0] = 1;
        comb[1] = 2;
        
        for(int i = 2; i < n; i++) {
            comb[i] = comb[i - 1] + comb[i - 2];
            comb[i] %= 1_000_000_007;
        }
        
        return comb[n - 1];
    } 
}