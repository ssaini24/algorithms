import topView.BinaryTree;
import topView.Pair;
import topView.TopView;

import java.util.TreeMap;

public class Main {

    private static BinaryTree root;

    public static void main(String[] args) {
        BinaryTree root = initTree();

        TreeMap<Integer, Pair> hashMap = new TreeMap<>();
        TopView topView = new TopView(hashMap);
        topView.topView(root);
    }


    /*
    *       3
    *      /  \
    *     2     4
    *    / \
    *   1   7
    *        \
    *         10
    * */
    public static BinaryTree initTree(){
        BinaryTree rightNode = new BinaryTree(10, null, null);

        BinaryTree level3First = new BinaryTree(1, null, null);
        BinaryTree level3Second = new BinaryTree(7, null, rightNode);

        BinaryTree level2First = new BinaryTree(2, level3First, level3Second);
        BinaryTree level2Second = new BinaryTree(4, null, null);

        return new BinaryTree(3, level2First, level2Second);
    }
}