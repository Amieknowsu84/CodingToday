class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev=new ArrayList<>();
        prev.add(1);
        result.add(prev);
        
        for(int i=2;i<=numRows;i++){
             List<Integer> list = new ArrayList<>();
             list.add(1);
             for(int j=1;j<prev.size();j++){
                 list.add(prev.get(j-1)+prev.get(j));
             }
             list.add(1);
             prev= list;
             result.add(prev);
        }
        
        return result;
        
    }
}