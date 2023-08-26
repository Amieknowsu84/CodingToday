/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    public Node construct(int[][] grid) {
        return construct(grid,0,grid.length-1,0,grid.length-1);
    }
    
     public Node construct(int[][] grid,int rs,int re,int cs,int ce) {
        if(haveSameValue(grid,rs,re,cs,ce)){
            //System.out.println(rs+" -- "+ re+ " "+cs+ " "+ce +" "+grid[rs][cs]);
            return new Node(grid[rs][cs]==1,true);
        } 
        int size = (re-rs+1)/2;
        int midr = rs+size;
        int midc = cs+size;  
        // (rs,rs+mid-1)  (mid,re) ;
        //int division=rs+mid-1;
      // System.out.println(rs+" "+ (mid-1)+ " "+mid+ " "+re);
         
        Node current=new Node(false,false);
        
        current.topLeft = construct(grid,rs,midr-1,cs,midc-1);
        current.topRight = construct(grid,rs,midr-1,midc,ce);
        current.bottomLeft =  construct(grid,midr,re,cs,midc-1);
        current.bottomRight =  construct(grid,midr,re,midc,ce);
         
        return current; 
         
    }
    
    
    
    boolean haveSameValue(int[][] grid,int rs,int re,int cs,int ce){
        int value=grid[rs][cs];
        for(int i=rs;i<=re;i++){
            for(int j=cs;j<=ce;j++){
                if(value!=grid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}