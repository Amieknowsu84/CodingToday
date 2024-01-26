class Solution {

    public List < Integer > distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode,TreeNode> parentMap = new HashMap <> ();
        setParent(parentMap, root);
        
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(target);
        visited.add(target.val);

        while (!queue.isEmpty() && K-- > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null && !visited.contains(node.left.val)){
                    visited.add(node.left.val);
                    queue.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right.val)){
                    visited.add(node.right.val);
                    queue.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if(parent!=null && !visited.contains(parent.val)){
                    visited.add(parent.val);
                    queue.add(parent);
                }
            }
            
        }

        return queue.stream().map(node->node.val).collect(Collectors.toList());
    }

    private void setParent(Map <TreeNode,TreeNode> parent, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left, root);
            setParent(parent, root.left);
        }
        if (root.right != null) {
            parent.put(root.right,root);
            setParent(parent,root.right);
        }
    }

}