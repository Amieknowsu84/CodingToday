class Solution {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }
    List<TreeNode> dfs(int from, int to){
        List<TreeNode> list = new ArrayList<>();
        if(from > to){
            list.add(null);
        }else {
            for(int i = from; i <= to; i++)
                for (TreeNode l : dfs(from, i - 1))
                    for (TreeNode r : dfs(i + 1, to))
                        list.add(new TreeNode(i, l, r));
        }
        return list;
    }
}