class Solution {
    private int helper(TreeNode root, int maxVal) {
        if(root == null) return 0;

        int isCurrentGood = 0;

        if(root.val >= maxVal) {
            maxVal = root.val;
            isCurrentGood = 1;
        }

        return isCurrentGood + helper(root.left, maxVal) + helper(root.right, maxVal);
    }
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }
}