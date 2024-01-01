class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int cnt = 0;
        int index = 0;
        
        for(int i=0; i < g.length;i++){
            
            if(index >= s.length){
                return cnt;
            }
            
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