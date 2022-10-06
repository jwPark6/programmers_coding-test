//다음 큰 숫자

class Solution {
    public int solution(int n) {
        char[] bin = Integer.toBinaryString(n).toCharArray();
        int lastIndex = bin.length - 1;
        int count = Integer.bitCount(n);

        for(int i = lastIndex; i >= 0; i--){
            if(bin[i]=='1'){
                n += Math.pow(2, lastIndex-i);
                bin = Integer.toBinaryString(n).toCharArray();
                count -= Integer.bitCount(n);
                for(int j = bin.length-1; count>0; j--, count--){
                    bin[j] = '1';
                }
                return Integer.parseInt(String.valueOf(bin), 2);
            }
        }
        return n;
    }
}