class Solution {
    public int countSeniors(String[] details) {
        
        Predicate<String> isGreaterThan60 = info -> {
            char tens = info.charAt(11);
            char ones = info.charAt(12);
            return (tens > '6' || (tens == '6' && ones > '0')) ? true : false;
        };
        
       long seniorCount =  Arrays.stream(details).
            filter(detail -> isGreaterThan60.test(detail))
            .collect(Collectors.counting());
        
       return (int) seniorCount;
    }
}