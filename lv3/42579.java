// 베스트앨범

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        HashMap<String, Integer> hmg = new HashMap<String, Integer>();
        HashMap<String, List<int[]>> hmp = new HashMap<String, List<int[]>>();
        
        for (int i = 0; i < plays.length; i++) {
            if (hmg.containsKey(genres[i])) hmg.put(genres[i], hmg.get(genres[i]) + plays[i]);
            else hmg.put(genres[i], plays[i]);
        }
        
        for (int i = 0; i < plays.length; i++) {
            if (hmp.containsKey(genres[i])) hmp.get(genres[i]).add(new int[]{i, plays[i]});
            
            else {
                List<int[]> temp = new ArrayList();
                temp.add(new int[]{i, plays[i]});
                hmp.put(genres[i], temp);
            }
            
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hmg.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        
        for(int i = entryList.size() - 1; i >= 0; i--) {
            List<int[]> list = hmp.get(entryList.get(i).getKey());
            
            list.sort(new Comparator<int[]>() {
                
                public int compare(int[] i1, int[] i2) {
                    if(i2[1] == i1[1]) return i1[0] - i2[0];
                    return i2[1] - i1[1];
                }
            });
            
            for(int j = 0; j < list.size() && j < 2; j++) {
                answer.add(list.get(j)[0]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}