/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* ATTENTION
I first used Stringbuilder(objective) instead of String(primitive), only to find the res is 1->2->5,1->2->53, which means what we passed through helper() is a reference instead of a copy(we can take a look at res, we keep adding things in res, it works like a global variable), if we insist using Stringbuilder, we need to remove the a corresponding length of this Stringbuilder then add new value to new path.
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String s = "";
        helper(root, res, s);
        return res;
    }
    public void helper(TreeNode root, List<String> res, String s){
        if(root != null){
            s+=root.val;
            if(root.left == null && root.right == null)
                res.add(s);
            
            else{
                s+="->";
                if(root.left != null) helper(root.left, res, s);
                if(root.right != null) helper(root.right, res, s); 
            }
        }  
    }
}