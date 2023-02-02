//2개 이하로 다른 비트

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        String bit = "";
        String temp = "";
        
        for(int i = 0; i < numbers.length; i++) {
            bit = "0" + Long.toBinaryString(numbers[i]);
            
            for (int j = bit.length() - 1; j >= 0; j--) {
                if (bit.charAt(j) == '0') {
                    if (j == bit.length() - 1) {
                        temp = bit.substring(0, j) + "1";
                    } else if (j == bit.length() - 2) {
                        temp = bit.substring(0, j) + "10";  
                    } else {
                        temp = bit.substring(0, j) + "10" + bit.substring(j+2, bit.length());
                    }
                    answer[i] = Long.parseLong(temp, 2);
                    break;
                } 
            }
        }

        return answer;
    }
}