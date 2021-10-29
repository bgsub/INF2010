
public class Interview {
    //TODO: completer
    public static TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        else if (t1 == null) return t2;
        else if (t2 == null) return t1;
        TreeNode result = new TreeNode((t1.val - t2.val <= 0) ? t1.val : t2.val);
        result.left = solution(t1.left, t2.left);
        result.right = solution(t1.right, t2.right);
        return result;
    }
}