//영어 끝말잇기

import java.util.Arrays;
import java.util.LinkedHashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(Arrays.asList(words));
        if(words.length == hashSet.size()){
            String prev = words[0];
            for(int i = 1; i< words.length; i++){
                if(prev.charAt(prev.length()-1) != words[i].charAt(0)){
                    return new int[]{(i%n)+1, (i/n)+1};
                }
                prev = words[i];
            }
            return new int[]{0,0};
        }
        else {
            String[] not_dup = hashSet.toArray(new String[0]);
            for (int i = 0; i < not_dup.length; i++) {
                if(!not_dup[i].equals(words[i])){
                    return new int[]{(i%n)+1, (i/n)+1};
                }
            }
        }
        return new int[]{((words.length-1)%n)+1, (words.length/n)};
    }
}