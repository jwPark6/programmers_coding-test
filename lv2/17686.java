// 파일명 정렬

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length]; 
        String[][] hnt = new String[files.length][3];
        
        Pattern p = Pattern.compile("[0-9]+"); // 1

		Matcher m;
        
        for (int i = 0; i < files.length; i++) { // 2
            String s = files[i];
            m = p.matcher(s);
            m.find();
            hnt[i][0] = s.substring(0, m.start());
            hnt[i][1] = s.substring(m.start(), m.end());
            hnt[i][2] = s.substring(m.end(), s.length());
        }
        
        Arrays.sort(hnt, new Comparator<String[]>() { // 3
            @Override
            public int compare(String[] o1, String[] o2) { // 4
                String h1 = o1[0].toLowerCase();
                String h2 = o2[0].toLowerCase();
                int n1 = Integer.parseInt(o1[1]);
                int n2 = Integer.parseInt(o2[1]);

                if (h1.equals(h2)) {
                    return n1 - n2;
                    
                } else {
                    return h1.compareTo(h2);
                }
            }
        });
        
        for (int i = 0; i < files.length; i++) { // 5
            answer[i] = hnt[i][0] + hnt[i][1] + hnt[i][2];
        }
        
        return answer;
    }
}