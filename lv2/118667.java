// 두 큐 합 같게 만들기

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;
        int[] all = new int[len * 2];
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < len; i++) {
            all[i] = queue1[i];
            sum1 += queue1[i];
        }
        
        for(int i = 0; i < len; i++) {
            all[i + len] = queue2[i];
            sum2 += queue2[i];
        }
        
        long sumHalf = (sum1 + sum2) / 2;
        int cursor1 = 0;
        int cursor2 = queue1.length;
        int temp1 = 0;
        int temp2 = 0;
        
        while(true) {
            //if (cursor1 == cursor2) return -1;
            if (answer >= len * 3) return -1;
            
            if(sum1 < sumHalf) {
                temp2 = all[cursor2++];
                sum1 += temp2;
                sum2 -= temp2;
                cursor2 %= len * 2;
            } else if (sum1 > sumHalf) {
                temp1 = all[cursor1++];
                sum2 += temp1;
                sum1 -= temp1;
                cursor1 %= len * 2;
            } else {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}