class Solution {
    public String removeKdigits(String num, int k) {
       Deque<Character> deque = new LinkedList<>();
        
        for(int i = 0; i < num.length(); i++) {
            while(!deque.isEmpty() && deque.peekLast() > num.charAt(i) && k > 0) {
                deque.removeLast();
                k--;
            }
            deque.addLast(num.charAt(i));
        }
        
        while(k > 0) {
            deque.removeLast();
            k--;            
        }
        
        StringBuilder res = new StringBuilder();
        boolean startZero = true;
        
        while(!deque.isEmpty()) {
            char elem = deque.removeFirst();
            if(startZero && elem == '0') {
                continue;   
            } else {
                startZero = false;
                res.append(elem);
            }
        }
        
        String result = res.toString();
        return result.equals("") ? "0" : result;
    }
}