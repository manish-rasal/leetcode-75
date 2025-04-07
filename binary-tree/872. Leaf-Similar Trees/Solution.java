class Solution {
    private void helper(TreeNode root, List<Integer> treeLeaves) {
        if(root.left == null && root.right == null) treeLeaves.add(root.val);

        if(root.left != null) helper(root.left, treeLeaves);

        if(root.right != null) helper(root.right, treeLeaves);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> treeLeaves1 = new ArrayList<>();
        List<Integer> treeLeaves2 = new ArrayList<>();
        helper(root1, treeLeaves1);
        helper(root2, treeLeaves2);

        return treeLeaves1.equals(treeLeaves2);
    }
}