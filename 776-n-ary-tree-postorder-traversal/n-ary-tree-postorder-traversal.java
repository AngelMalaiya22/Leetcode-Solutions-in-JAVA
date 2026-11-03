import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    private void postorderTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // 1. Visit all children first
        if (root.children != null) {
            for (Node child : root.children) {
                postorderTraversal(child, result);
            }
        }

        // 2. Add current node value after visiting children
        result.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
}