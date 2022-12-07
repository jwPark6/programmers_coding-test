import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    int basicTime;
    int basicFee;
    int unitTime;
    int unitFee;
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String[] inforCar = {};
        int time = 0;
        String carNumber = "";
        String history = "";
        
        for(String s : records){
            inforCar = s.split(" ");
            time = hour2min(inforCar[0]);
            carNumber = inforCar[1];
            history = inforCar[2];
            
            if(history.equals("IN")){
                hm.put(carNumber, time);
            }
            else{
                int resultTime = time - hm.get(carNumber);
                if(result.containsKey(carNumber)) resultTime += result.get(carNumber);
                result.put(carNumber, resultTime);
                hm.remove(carNumber);
            }  
        }
        
        hm.forEach((k, v) -> {
            int resultTime = 1439 - v;
            if(result.containsKey(k)) resultTime += result.get(k);
            result.put(k, resultTime);
        });
        
        int[] answer = new int[result.size()];
        List<String> keys = new ArrayList<>(result.keySet());
        Collections.sort(keys);
        Iterator<String> iterator = keys.iterator();

        for(int i = 0; i < answer.length; i++){
            answer[i] = calculateResult(result.get(iterator.next()));
        }
       
        return answer;
    }
    
    public int calculateResult(int time){
        if(time <= basicTime){
            return basicFee;
        }
        float result = (time-basicTime) / (float) unitTime;
        
        return (int) (Math.ceil(result) * unitFee) + basicFee;
    }
    
    public int hour2min(String hour){
        String[] temp = hour.split(":");
        int i = Integer.parseInt(temp[0]) * 60;
        i += Integer.parseInt(temp[1]);
        return i;
    }
}