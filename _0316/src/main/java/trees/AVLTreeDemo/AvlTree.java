package trees.AVLTreeDemo;


import java.util.*;

/**
 * @author Yan
 * @create 2023-05-05 14:57
 **/
public class AvlTree {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,11};
        avlTree avlTree = new avlTree();
        Node1 node0 = new Node1(7);
        Node1 node1 = new Node1(3);
        Node1 node2 = new Node1(10);
        Node1 node3 = new Node1(12);
        Node1 node4 = new Node1(11);
        avlTree.add(node0);
        avlTree.add(node1);
        avlTree.add(node2);
        avlTree.add(node3);
        avlTree.add(node4);
        avlTree.infixOrder();
        System.out.println("***********");
//        avlTree.rightRotate(node3);
//        avlTree.leftRotate(node2);
        System.out.println(node3.parent.value);
        System.out.println(node2.parent.value);
        System.out.println(node4.height);
        Deque<Integer> deque = new ArrayDeque();

//        avlTree.infixOrder();
//        System.out.println(node4.parent.value);
    }


    static class avlTree{

        Node1 root;
        public avlTree(Node1 root){
            this.root = root;
        }

        public avlTree() {
        }

        public void add(Node1 node){
            if (root == null){
                root = node;
                reBalance(node);
            }else {
                root.add(node);
                reBalance(node);
            }
        }
        public void infixOrder(){
            this.root.infixOrder();
        }
        public void rightRotate(Node1 x){
            Node1 y = x.left;
            y.parent = x.parent;
            if (y.parent == null){
                this.root = y;
            }else {
                if (y.parent.left == x){
                    y.parent.left = y;
                }
                if (y.parent.right == x){
                    y.parent.right = y;
                }
            }
            x.left = y.right;
            if (x.left != null){
                x.left.parent = x;
            }
            y.right = x;
            x.parent = y;
            updateHeight(x);
            updateHeight(y);
        }

        public void leftRotate(Node1 x){
            Node1 y = x.right;
            y.parent = x.parent;
            if (y.parent == null){
                this.root = y;
            }else {
                if (y.parent.right == x){
                    y.parent.right = y;
                }
                if (y.parent.left == x){
                    y.parent.left = y;
                }
            }
            x.right = y.left;
            if (x.right != null){
                x.right.parent = x;
            }
            y.left = x;
            x.parent = y;
            updateHeight(x);
            updateHeight(y);
        }
        public int height(Node1 node){
            if (node == null){
                return -1;
            }else {
                return node.height;
            }
        }

        public void updateHeight(Node1 node){
            node.height = Math.max(height(node.left),height(node.right)) + 1;
        }

        public void reBalance(Node1 node){
            while (node != null){
                updateHeight(node);
                if (height(node.right) >= 2 + height(node.left)){
                    if (height(node.right.right) > height(node.right.left)){
                        leftRotate(node);
                    }else {
                        rightRotate(node.right);
                        leftRotate(node);
                    }
                } else if (height(node.left) >= 2 + height(node.right)) {
                    if (height(node.left.left) > height(node.left.right)){
                        rightRotate(node);
                    }else {
                        leftRotate(node.right);
                        rightRotate(node);
                    }
                }
                node = node.parent;
            }

        }

    }

    static class Node1{

        int value;
        Node1 left;
        Node1 right;
        Node1 parent;
        int height;


        public Node1(int value){
            this.value = value;
        }

        public void add(Node1 node){
            if (node == null ){
                return;
            }
            //判断传入结点的值和当前子树的根节点的关系
            if (node.value < this.value){
                if (this.left == null){
                    this.left = node;
                    node.parent = this;
                }else {
                    //递归的向左子树添加
                    this.left.add(node);
                }
            }else {
                if (this.right == null){
                    this.right = node;
                    node.parent = this;
                }else {
                    this.right.add(node);
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
}

