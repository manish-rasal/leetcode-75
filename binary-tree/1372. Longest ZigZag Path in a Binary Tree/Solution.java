class Solution {
    private int result;
    private void helper(TreeNode root, int depth, char origin) {
        result = Math.max(result, depth);

        if(root.left != null) {
            helper(root.left, ((origin == 'l')? 1: depth + 1), 'l');
        }

        if(root.right != null) {
            helper(root.right, ((origin == 'r')? 1: depth + 1), 'r');
        }

    }
    public int longestZigZag(TreeNode root) {
        result = 0;
        helper(root, 0, 'd');
        return result;
    }
}