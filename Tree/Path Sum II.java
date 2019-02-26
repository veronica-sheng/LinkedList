/*
113
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

12/10/2018 14:38 - 15:23
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, temp, res);
        return res;
    }
    public void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res){
        if(root == null) return;
        temp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList<>(temp));
        else{
            helper(root.left, sum - root.val, temp, res);
            helper(root.right, sum - root.val, temp, res);
        }
        temp.remove(temp.size() -1);//backtracking
    }
}