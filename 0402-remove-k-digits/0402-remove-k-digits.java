class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<num.length(); i++){
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.add(num.charAt(i));
        }
        
        while(k>0){
            st.pop();
            k--;            
        }
        
        
        StringBuilder res = new StringBuilder();
        boolean startZero = true;
        LinkedList<Character> list = new LinkedList<>(st);
        //System.out.println(list);
        
        while(!list.isEmpty()){
            char elem = list.removeFirst();
            if(startZero && elem == '0'){
              continue;   
            }else{
                startZero = false;
                res.append(elem);
            }
        }
        
        String result = res.toString();
        return result.equals("") ? "0" : result;
    }
}