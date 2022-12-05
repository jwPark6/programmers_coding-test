import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    class Location{
        int location;
        int value;
        
        public Location(int location, int value){
            this.location = location;
            this.value = value;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Location> queue = new LinkedList<>();
        int count = 0;
        boolean check = false;
        
        for(int i=0; i < priorities.length; i++){
            queue.offer(new Location(i, priorities[i]));
        }

        while(!queue.isEmpty()){
            Location l = queue.poll();
            check = false;
            for(Location temp : queue){
                if(l.value < temp.value){
                    check = true;
                    break;
                }
            }
            
            if(check){
                queue.offer(l);
            }
            else{
                count++;
                if(l.location == location){
                    return count;
                }
            }
        }
        return 0;
    }
}