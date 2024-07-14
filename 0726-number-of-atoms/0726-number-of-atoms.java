class Solution {
    public String countOfAtoms(String formula) {
     if(formula == null || formula.length() == 0) return "";
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        HashMap<String,Integer> currMap = new HashMap<String,Integer>();
        stack.push(currMap);
        for(int i = 0;i<formula.length();i++){
            //Case 1: put everthing after "(" in new HashMap, and put in stack
            if(formula.charAt(i) == '('){
                currMap = new HashMap<>();
                stack.push(currMap);
            //Case 2: multiple and then merge top 2 object in stack
            }else if(formula.charAt(i) == ')'){
                HashMap<String,Integer> tempMap = stack.pop();
                //count structure
                int count = 0;
                if(i+1 == formula.length() || !Character.isDigit(formula.charAt(i+1))){
                    count = 1;
                }else{
                    while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))){
                        count = count * 10 + (formula.charAt(i+1) - '0');
                        i++;
                    }
                }
                merge(stack.peek(),tempMap,count);
                //update the pointer
                currMap = stack.peek();
            //Case 3: put atoms in the top object in stack, update count
            }else {
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(i));
                while(i+1<formula.length() && Character.isLowerCase(formula.charAt(i+1))){
                    sb.append(formula.charAt(i+1));
                    i++;
                }
                //count structure
                int count = 0;
                //case1: no digit follows when meet with UpperCase
                if(i+1 == formula.length() || !Character.isDigit(formula.charAt(i+1))){
                    count = 1;
                }else{
                //case2: meet with digits
                    while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))){
                        count = count * 10 + (formula.charAt(i+1) - '0');
                        i++;
                    }
                }
                String atom = sb.toString();
                int number = currMap.getOrDefault(atom,0);
                currMap.put(atom,number+count);
                
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(stack.peek());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry: treeMap.entrySet()){
            sb.append(entry.getKey());
            if(entry.getValue() != 1){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
    public void merge(HashMap<String,Integer> map,HashMap<String,Integer> tempMap, int count){
        for(Map.Entry<String,Integer> entry: tempMap.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            int number = map.getOrDefault(key,0);
            number += val * count;
            map.put(key,number);
        }
    }
}