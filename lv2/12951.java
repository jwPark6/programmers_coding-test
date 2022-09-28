class Solution {
    public String solution(String s) {
        String answer = makeJadenCase(s);
        return answer;
    }
    
    public String makeJadenCase(String s){
        s = s.toLowerCase();
        String[] splitStrings = s.split(" ");
        String result = "";

        for(String splitString : splitStrings) {
            if(splitString.equals("")){
                result += " ";
                continue;
            }
            
            char c = splitString.charAt(0);

            if(c < 123 && c > 96){
                c -= 32;
            }
            result += c + splitString.substring(1, splitString.length()) + " ";
        }
        result = result.substring(0, result.length()-1);
        return result + s.substring(result.length(), s.length());
    }
}

