//구명보트

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 1;
        int sum = 0;
        int start = 0;

        for(int i=people.length-1; i>=start; i--){
            sum = people[i];
            while(i>start){
                if(sum + people[start] < limit){
                    sum += people[start++];
                }
                else if(sum + people[start] == limit){
                    sum += people[start++];
                    answer++;
                    break;
                }
                else{
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}