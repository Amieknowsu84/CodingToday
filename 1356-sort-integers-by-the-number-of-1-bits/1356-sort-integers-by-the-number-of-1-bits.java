class Solution {
    
    public int[] sortByBits(int[] arr) {
        
        Integer[] arrObj = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrObj[i] = arr[i];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int element : arr) {
            if (!map.containsKey(element)) {
                map.put(element, Integer.bitCount(element));
            }
        }

        Arrays.sort(arrObj, (a, b) -> {
            int diff = map.get(a) - map.get(b);
            if (diff == 0) {
                return a - b;
            }
            return diff;
        });

    
        for (int i = 0; i < arr.length; i++) {
             arr[i] = arrObj[i];
        }
        
        return arr;
    }
}