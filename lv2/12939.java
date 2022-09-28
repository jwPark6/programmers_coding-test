import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = result(s);
        return answer;
    }
    
    public String result(String s){
        String[] chars = s.split(" ");
        int[] chars2int = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            chars2int[i] = Integer.parseInt(chars[i]);
        }
        
        Arrays.sort(chars2int);       
        return chars2int[0] + " " + chars2int[chars2int.length-1];
    } 
}
