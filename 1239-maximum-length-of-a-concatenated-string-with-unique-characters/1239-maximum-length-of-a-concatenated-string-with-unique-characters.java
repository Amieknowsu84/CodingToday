class Solution {
    int count[];
    int max;
    
    public int maxLength(List<String> arr) {
        count=new int[26];
        max=0;
        solve(arr,0,0,new LinkedList<>());
        return max;
    }
    
     void solve(List<String> arr,int cnt,int index,LinkedList<String> result){
         
         if(!containsDuplicate(String.join("", result))){
             max=Math.max(max,cnt);
         }else{
             return;
         }
         
         if(index>=arr.size()){
             return;
         }
         
         for(int i=index;i<arr.size();i++){
                String str=arr.get(i);
                cnt+=str.length();
                result.add(arr.get(i));
                solve(arr,cnt,i+1,result);
                result.removeLast();
                cnt-=str.length();
        }
    }
         
    
    
     boolean containsDuplicate(String s){
         int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
          for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']>1){
                return true;
            }
        }
         return false;
    }

}