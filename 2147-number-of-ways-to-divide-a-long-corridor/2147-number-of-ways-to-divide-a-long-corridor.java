class Solution {
    public int numberOfWays(String corridor) {
        final int Mod = 1000000007;
                       
        ArrayList<Integer> seats = new ArrayList<>();
        long res = 1;
        for(int i=0;i<corridor.length();i++){
            char c = corridor.charAt(i);
            if(c=='S') seats.add(i);
        }

        int s = seats.size();
        if(s%2 != 0 || s==0) {
        return 0;
        }

        int preind = seats.get(1);
        for(int i=2;i<s;i+=2){
            int len = seats.get(i)-preind;
            res = (res*len) % Mod;
            preind = seats.get(i+1);
        }
        return (int)res;
    }
}