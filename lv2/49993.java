class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String compare = "";
        String[] ss;
        
        for(String st : skill_trees){
            ss = st.split("");
            for(String s : ss){
                if(skill.contains(s)) compare += s;
            }
            if (skill.indexOf(compare) == 0) answer++;
            compare = "";
        }
        return answer;
    }
}