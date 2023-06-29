package trees.HuffmanTreeDemo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Yan
 * @create 2023-04-09 10:06
 **/
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("树为空！");
        }
    }

    public static Node createHuffmanTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr){
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1){

            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }
        return nodes.get(0);

    }





}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public Node(int value){
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
