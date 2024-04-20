class Solution {
    int r1;
    int r2;
    int c1;
    int c2;
    int max;
    int min;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<land.length; i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j] == 1){
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;
                    dfs(i,j,land);
                    list.add(new int[]{r1,c1,r2,c2});
                }
            }
        }
        
       int[][] array = new int[list.size()][];

      for (int i = 0; i < list.size(); i++) {
           array[i] = list.get(i);
       }
        
       return array; 
        
    }
    
    void dfs(int i,int j,int[][] land){
        
        if(i<0||j<0||i>=land.length||j>=land[0].length){
            return;
        }
        
        if(land[i][j]  == 0 || land[i][j] == 2){
            return;
        }
         
        land[i][j] = 2;
        if(i+j<min){
            r1 = i;
            c1 = j;
            min = i+j;
        }
        if(i+j>max){
            r2 = i;
            c2 = j;
            max = i+j;
        }
        
        for(int k=0;k<dx.length;k++){
            dfs(i+dx[k],j+dy[k],land);
        }
    }
}