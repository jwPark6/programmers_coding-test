// 괄호 변환

class Solution {    
    public String solution(String p) {  
        return parsing(p, 0, 0);
    }
    
    public String parsing(String s, int c1, int c2) {
        if(s.equals("")) return "";
        
        String u = "";
        String v = "";
        char temp;
        
        for(int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            
            if (temp == ')') {
                c1++;
            } else if (temp == '(') {
                c2++;
            }
                
            if(c1 == c2) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1, s.length());
                break;
            }    
        }
        
        if(u.charAt(0) == '(') {
            return u + parsing(v, 0, 0);
        } else {
            return "(" + parsing(v, 0, 0) + ")" + reverse(u);    
        }
    }
    
    public String reverse(String s) {
        String temp = "";
        
        for(int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(') temp += ")";
            else if (s.charAt(i) == ')') temp += "(";
        }
        
        return temp;
    }
}