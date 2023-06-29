package trees.binarySortTree;

/**
 * @author Yan
 * @create 2023-04-17 21:38
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {

        int[] arr = {7,3,10,12,11};
        binarySortTree binarySortTree = new binarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node1(arr[i]));
        }
        binarySortTree.infixOrder();

    }
}
class binarySortTree{
    private Node1 root;

    public void add(Node1 node1){
        if (root == null){
            root = node1;
        }else {
            root.add(node1);
        }
    }
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }
    }

}




class Node1 {

    int value;
    Node1 left;
    Node1 right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node1(int value){
        this.value = value;
    }

    public void add(Node1 node1){
        if (node1 == null ){
            return;
        }
        //判断传入结点的值和当前子树的根节点的关系
        if (node1.value < this.value){
            if (this.left == null){
                this.left = node1;
            }else {
                //递归的向左子树添加
                this.left.add(node1);
            }
        }else {
            if (this.right == null){
                this.right = node1;
            }else {
                this.right.add(node1);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null){
            this.right.infixOrder();
        }
    }


}
