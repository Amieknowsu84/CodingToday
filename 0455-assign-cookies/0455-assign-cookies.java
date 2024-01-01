class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int cnt = 0;
        int index = 0;
        int size = Math.min(g.length,s.length);
        
        for(int i=0; i < size;i++){
            
            if(index >= s.length)
                return cnt;
            
            if(s[index] >= g[i]){
                cnt++;
            }else{
                i--;
            }
            
            index++;
        }
        
        return cnt;
    }
}