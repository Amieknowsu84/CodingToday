class Solution {
//       12345678910
//       leetleetcode   
//     //leet2code3
//       leetleetcodeleetleetcodeleetleetcode
//       leetleet    
          
//      size=4 (4*2+4)*3=36
//      k=4
/*
If we have a decoded string like appleappleappleappleappleapple and an index like K = 24, the answer is the same if K = 4.

In general, when a decoded string is equal to some word with size length repeated some number of times (such as apple with size = 5 repeated 6 times), the answer is the same for the index K as it is for the index K % size.

We can use this insight by working backwards, keeping track of the size of the decoded string. Whenever the decoded string would equal some word repeated d times, we can reduce K to K % (word.length).
*/
    
    public String decodeAtIndex(String s, int k) {
        
        long size = 0;
        
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                size+=1;
            }else{
                size*=(s.charAt(i)-'0');
            }
        }
        //System.out.println(size);
        
        for(int i=s.length()-1;i>=0;i--){
            k=(int)(k%size);
            
            if(( k == 0)&& Character.isAlphabetic(s.charAt(i))){
                return ""+s.charAt(i);
            }
            
            if(Character.isDigit(s.charAt(i))){
                size/=(s.charAt(i)-'0');
            }else{
                size-=1;
            }
        }
        
        
        return "";
        
        
    }
}