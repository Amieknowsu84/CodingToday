class Solution {
    public int equalPairs(int[][] grid) {

        Map<String,Integer> hm=new HashMap<>();
        for(int row[]:grid){
            hm.merge(Arrays.toString(row),1,Integer::sum);
        }
        
        int cnt=0;
        for(int c=0;c<grid[0].length;c++){
            int column[]=new int[grid.length];
            for(int r=0;r<grid.length;r++){
                column[r]=grid[r][c];
            }
           cnt+=hm.getOrDefault(Arrays.toString(column),0);
        }
        
        return cnt;
    }
}