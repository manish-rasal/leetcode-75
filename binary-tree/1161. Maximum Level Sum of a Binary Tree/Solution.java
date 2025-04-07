class Solution {
    public int maxLevelSum(TreeNode root) {
        int level = 1, result = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while(size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                result = level;
            }
            level++;
        }
        return result;
    }
}