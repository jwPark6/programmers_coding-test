class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)]; // 1
        int r = (int) (left / n); // 2
        int c = (int) (left % n);
        long count = left;
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = (r > c) ? r + 1 : c + 1; // 3
            r = (int) (++count / n); // 4
            c = (int) (count % n);
        }
        return answer;
    }
}