import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> index = new ArrayList<>();
        String word = "";
        String prevWord = "";
        int value = 0;
        
        for(int i = 65; i < 91; i++){
            index.add(String.valueOf((char) i));
        }
        
        for(int i = 0; i < msg.length();){
            for(int j = i+1; j <= msg.length(); j++){
                word = msg.substring(i, j);
                
                if(index.contains(word)){
                    prevWord = word;
                    value = index.indexOf(prevWord) + 1;
                }
                else{
                    index.add(word);
                    answer.add(value);
                    i = j - 1;
                    break;
                }
            }
            if(msg.substring(i, msg.length()).equals(word)){
                answer.add(value);
                break;
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}