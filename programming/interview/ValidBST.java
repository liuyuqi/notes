Thoughts:

1. The easiest solution of this problem is by recursion. However, I have to consider how to implement the function --- aka, interfaces. I chose to pass the range as arguments and return the boolean value (which is a judgment). In this way, my function will looks more neat.

2. I could also pass only the node as the argument, and return a tuple (list). In this way, it could be more tricky.

3. Possible implementations of (2) can be:
    a. returns a list of two elements, of which the first one is a judgment, and the second is a range;
    b. returns only a range. If any invalidation is found, make the range an illegal one (like [2, 1])...

=============================================
Code:
---------------------------------------

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return isValidBSTRecurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBSTRecurse(TreeNode root, long min, long max) {
        boolean leftValid = true, rightValid = true;
        long newMin, newMax;
        if (root.val <= min || root.val >= max)
            return false;
            
        if (root.left != null) {
            newMax = (long) ((root.val < max) ? root.val : max);
            leftValid = isValidBSTRecurse(root.left, min, newMax);
        }
            
        if (root.right != null) {
            newMin = (long) ((root.val > min) ? root.val : min);
            rightValid = isValidBSTRecurse(root.right, newMin, max);
        }
            
        if (leftValid == false || rightValid == false)
            return false;
        else
            return true;
    }
}
