class Solution {
    public int[] twoSum(int[] n, int t) {
       HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        int a[]=new int[2];
        hs.put(t-n[0],0);
        for(int i=1;i<n.length;i++)
            if (hs.containsKey(n[i])) 
            {  a[0]= hs.get(n[i]); a[1]=i; break;}
           else{
               hs.put(t-n[i],i);
           }
              
         return a;     
    }
}