class Solution {
    public int binSearch(int[] t, int ele)
    {
        int start=0;
        int end=t.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;

            if(t[mid]==ele)
            {
                return mid;
            }
            else if (t[mid]<ele)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return -1;
    }
    public List<String> buildArray(int[] target, int n) {
        int [] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
        }
        List<String> returning_str=new ArrayList<>();
        int target_index=0;

        for(int i=0;i<n;i++)
        {
            int ischeck=binSearch(target,arr[i]);
            if(ischeck!=-1 && target_index<target.length)
            {
                returning_str.add("Push");
                target_index++;


            }
            else if(target_index<target.length)
            {
                returning_str.add("Push");
                returning_str.add("Pop");

            }
            
        }
        return returning_str;

        
    }
}