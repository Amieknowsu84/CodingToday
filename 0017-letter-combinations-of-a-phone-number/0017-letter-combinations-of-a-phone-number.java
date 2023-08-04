class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {

        result=new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }

        HashMap<Character,String> hmap=new HashMap<>();
        hmap.put('2',"abc");
        hmap.put('3',"def");
        hmap.put('4',"ghi");
        hmap.put('5',"jkl");
        hmap.put('6',"mno");
        hmap.put('7',"pqrs");
        hmap.put('8',"tuv");
        hmap.put('9',"wxyz");
        createCombination(digits,hmap,0,new StringBuilder());
        return result;
    }

    void createCombination(String digits,HashMap<Character,String> hmap,int index,StringBuilder sb){
       if(index==digits.length()){
           result.add(sb.toString());
           return;
       }
       String letters=hmap.get(digits.charAt(index));
       for(int i=0;i<letters.length();i++){
           sb.append(letters.charAt(i));
           createCombination(digits,hmap,index+1,sb);
           sb.deleteCharAt(sb.length() - 1);
       }

    }
}