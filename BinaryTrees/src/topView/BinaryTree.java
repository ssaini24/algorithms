package topView;

public class BinaryTree {
    int val;
    BinaryTree leftNode;
    BinaryTree rightNode;

    public BinaryTree(int val, BinaryTree leftNode, BinaryTree rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.val = val;
    }
}
