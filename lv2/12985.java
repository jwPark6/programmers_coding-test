//예상 대진표

class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 0;
        while(a != b){
            a = Math.round((float) a/2);
            b = Math.round((float) b/2);
            count++;
        } 
        
        return count;
    }
}