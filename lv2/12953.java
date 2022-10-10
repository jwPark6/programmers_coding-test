//N개의 최소공배수

import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=0; i<arr.length-1; i++){
            a = arr[i];
            b = arr[i+1];
            c = b%a;
            while(c!=0){
                b = a;
                a = c;
                c = b%a;
            }
            arr[i+1] = arr[i]*arr[i+1]/a;
        }
        
        return arr[arr.length-1];
    }
}