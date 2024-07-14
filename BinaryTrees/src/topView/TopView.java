package topView;

import java.util.Map;
import java.util.TreeMap;

public class TopView {

    private TreeMap<Integer, Pair> hashMap;

    public TopView(TreeMap<Integer, Pair> hashMap){
        this.hashMap = hashMap;
    }

    public void topView(BinaryTree root){
        traverse(root, 0, 0);
        printView();
    }

    private void traverse(BinaryTree root, int vertical, int depth){
        if (root == null)
            return;

        if (!hashMap.containsKey(vertical))
            hashMap.put(vertical, new Pair(depth, root.val));
        else {
          int existingDepth  =  hashMap.get(vertical).getDepth();
          if (existingDepth > depth){
              hashMap.put(vertical, new Pair(depth, root.val));
          }
        }

        traverse(root.leftNode, vertical-1, depth+1);
        traverse(root.rightNode, vertical+1, depth+1);
    }

    private void printView(){
        for (Map.Entry<Integer, Pair> entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + " "  + entry.getValue().getVal());
        }
    }
}
