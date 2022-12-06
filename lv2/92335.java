class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        boolean check = true;
        String[] ks = Integer.toString(n, k).split("0");
        
        for(String s : ks){
            if(!s.equals("")){
                check = true;
                long prime = Long.parseLong(s);
                if(prime == 1) continue;
                
                for(int i = 2; i <= Math.sqrt(prime); i++){
                    if(prime % i == 0){
                        check = false;
                        break;
                    }
                }
                if (check) answer++;
            }
        }
        return answer;
    }
}