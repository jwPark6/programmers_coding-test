// 방금 그 곡

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int min = 0;
        int len = 0;
        String title = "";
        String note = "";
        String conv = "";
        String[] temp;
        int maxMin = 0;
       
        for(int i = 0; i < musicinfos.length; i++) {
            temp = musicinfos[i].split(",");
            conv = convert(temp[3]);
            len = conv.length();
            min = getMin(temp[0], temp[1]);
            title = temp[2];
            note = "";
            
            for (int j = 0; j < min / len; j++) {
                note += conv;
            }
            note += conv.substring(0, min % len);
            
            if (note.contains(convert(m))) {               
                if(maxMin < min) {
                    maxMin = min;
                    answer = title;
                }
            }
        }
        
        if (answer.equals("")) return "(None)";
        return answer;
    }
    
    public int getMin(String s1, String s2) {
        int i1 = Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(3, 5));
        int i2 = Integer.parseInt(s2.substring(0, 2)) * 60 + Integer.parseInt(s2.substring(3, 5));
        
        return i2 - i1;
    }
    
    public String convert(String s) {   
        s = s.replaceAll("C#", "ㄱ");
        s = s.replaceAll("D#", "ㄴ");
        s = s.replaceAll("F#", "ㄷ");
        s = s.replaceAll("G#", "ㄹ");
        s = s.replaceAll("A#", "ㅁ");
        
        return s;
    }
}