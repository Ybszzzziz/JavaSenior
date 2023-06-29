package trees.ThreadedBinaryTreeDemo;

/**
 * @author Yan
 * @create 2023-04-02 9:28
 **/
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree1 tBinaryTree = new ThreadedBinaryTree1();
        tBinaryTree.setRoot(root);

        tBinaryTree.threadedNodes();
        tBinaryTree.threadInfixList();

//        System.out.println(node3.getRight());
//        tBinaryTree.threadPostList();
//        tBinaryTree.threadPostList();
//
//        HeroNode leftNode = node5.getLeft();
//        HeroNode right = node5.getRight();
//        System.out.println(right);

    }


}

//定义线索化二叉树
class ThreadedBinaryTree1{
    private HeroNode root;
    private HeroNode pre = null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadInfixList(){
        HeroNode node = root;
        while (node != null){

            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadPreList() {
        HeroNode node = root;
        while (node != null) {
            System.out.println(node);
            if (node.getLeft() != null && node.getLeftType() == 0){
                node = node.getLeft();
            }else {
                node = node.getRight();
            }
        }
    }
    public void threadPostList(){
        HeroNode node = root;
        while (node != null){
            while (node.getLeft() != null && node.getLeftType() == 0){
                node = node.getLeft();
            }
            while (node != null && node.getRightType() == 1){
                System.out.println(node);
                pre = node;
                node = node.getRight();
            }
            if (node == root){
                System.out.println(node);
                return;
            }

        }
    }



    //中序线索化
    public void threadedNodes(HeroNode node){

        if (node == null){
            return;
        }
        //1.先线索化左子树
        threadedNodes(node.getLeft());
        //2.线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点，让当前节点是下一个结点的前驱节点
        pre = node;

        //3.线索化右子树
        threadedNodes(node.getRight());
    }
    //前序线索化
    public void threadedPreNodes(HeroNode node){
        if (node == null){
            return;
        }
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getLeftType() == 0 ){

            threadedPreNodes(node.getLeft());
        }
        if (node.getRightType() == 0){

            threadedPreNodes(node.getRight());
        }

    }

    public void threadedPostNodes(HeroNode node){
        if (node == null){
            return;
        }
        threadedPostNodes(node.getLeft());
        threadedPostNodes(node.getRight());
        //处理当前节点的前驱节点
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点，让当前节点是下一个结点的前驱节点
        pre = node;
    }


    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序查找
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("树不存在");
        }
    }
}

//先创建节点HeroNode
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    /**
     * leftType == 0 左指针指向左子树，如果为1，指向前驱节点
     * rightType == 0 右指针指向右子树，如果为1，指向后继节点
     */
    private int leftType;
    private int rightType;


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //提柜想左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归想右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }
    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }

    }
}

