class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer,List<int[]>> adjacency = new HashMap<>();
        
        for(int[] meeting: meetings){
            List<int[]> list = adjacency.computeIfAbsent(meeting[0],(k)->new ArrayList<>());
            list.add(new int[]{meeting[1],meeting[2]});
            adjacency.put(meeting[0],list);
            list = adjacency.computeIfAbsent(meeting[1],(k)->new ArrayList<>());
            list.add(new int[]{meeting[0],meeting[2]});
            adjacency.put(meeting[1],list);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        int visited[] = new int[n];
        queue.add(new int[]{0,0});
        queue.add(new int[]{firstPerson,0});
        
        Set<Integer> result = new HashSet<>();
        
        while(!queue.isEmpty()){
            int[] node = queue.remove();
            visited[node[0]] = 1;
            //System.out.println(node[0]+" "+node[1]);
            result.add(node[0]);
            if(adjacency.containsKey(node[0]))
            for(int[] adjacent:adjacency.get(node[0])){
                if(visited[adjacent[0]]!=1 && adjacent[1]>=node[1]){
                    //System.out.println(node[0]+"-----"+adjacent[0]);
                    queue.add(adjacent);
                }
            }
        }
        
        return new ArrayList<>(result);
        
    }
}