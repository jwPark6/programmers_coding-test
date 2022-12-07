import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final String ENTER = ",님이 들어왔습니다.";
    private static final String LEAVE = ",님이 나갔습니다.";
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<String, String>();

        for(String user : record){
            check(user, hm);
        }

        for(int i = 0; i < answer.size(); i++){
            String[] ss = answer.get(i).split(",");
            answer.set(i, hm.get(ss[0]) + ss[1]);
        }
        String[] r = answer.toArray(new String[answer.size()]);
        return r;
    }

    public void check(String user, HashMap<String, String> hm){
        String[] temp = user.split(" ");
        String infor = temp[0];
        String id = temp[1];
        String name = (temp.length == 3) ? temp[2] : "";

        if (!infor.equals("Leave")) {
            hm.put(id, name);
        }
        if (!infor.equals("Change")) answer.add(infor.equals("Enter") ? id + ENTER : id + LEAVE);
    }
}