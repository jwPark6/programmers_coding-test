import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        float answer = 0;
        List<String> set1 = makeSet(str1);
        List<String> set2 = makeSet(str2);
        int union = checkUnion(set1, set2);
        int inter = checkInter(set1, set2);
        union -= inter;
        if(union == 0 && inter == 0) return 65536;
        answer = ((float)inter/(float) union) * 65536;
        return (int) answer;
    }
    
    public List<String> makeSet(String str){
        str = str.toLowerCase();
        char[] ss = str.toCharArray();
        String temp = "";
        List<String> elements = new ArrayList<>();
        
        for(char c : ss){
            temp += c;
            if (temp.length() == 2) {
                if (temp.matches("[a-z]+")) {
                    elements.add(temp);
                }
                temp = temp.substring(1, 2);
            }
        }
        return elements;
    }
    
    public int checkInter(List<String> set1, List<String> set2){
        int count = 0;
        for(String s : set1){
            if(set2.contains(s)){
                count++;
                set2.remove(s);
            }
        }
        return count;
    }
    
    public int checkUnion(List<String> set1, List<String> set2){
        return set1.size() + set2.size();
    }
}