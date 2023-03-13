// 단어 변환

class Solution {
    boolean[] check;
    String[] words;
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        this.words = words;
        
        dfs(begin, 0, target);
        
        return answer;
    }
    
    public void dfs(String begin, int count, String target) {
        
        if (begin.equals(target)) {
            answer = (answer == 0) ? count : Math.min(answer, count);
            return;
        }
        
        for (int j = 0; j < check.length; j++) {
            if (!check[j] && canChange(begin, words[j])) {
                check[j] = true;
                dfs(words[j], count + 1, target);
                check[j] = false;
            }
        }
    }
    
    public boolean canChange(String begin, String word) {
        char[] bss = begin.toCharArray();
        char[] wss = word.toCharArray();
        int count = 0;   
     
        for (int i = 0; i < bss.length; i++) {
            if (bss[i] != wss[i]) count++;
        }
        
        if (count == 1) return true;
        return false;
    }
}