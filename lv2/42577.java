import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length-1; i++){
            String str1 = phone_book[i];
            for(int j = i+1; j < phone_book.length; j++){
                String str2 = phone_book[j];
                if(str1.length() == str2.length()){
                    break;
                }
                if(str2.indexOf(str1) == 0){
                    return false;
                }
            }
        }
        return answer;
    }
}