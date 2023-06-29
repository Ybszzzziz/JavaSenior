package trees.BinaryTreeDemo;

/**
 * @author Yan
 * @create 2023-04-01 16:52
 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree binaryTree = new ArrBinaryTree(arr);
//        binaryTree.infixOrder(0);
//        binaryTree.preOrder();
        binaryTree.postOrder(0);

    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载
    public void preOrder(){
        this.preOrder(0);
    }

    /**
     *
     * @param index 数组下标
     */
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能遍历");
        }
        System.out.println(arr[index]);
        if (index * 2 + 1  < arr.length){
            preOrder( index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }

    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        if (index * 2 + 1 < arr.length){
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        if (index * 2 + 2 < arr.length){
            infixOrder(index * 2 + 2);
        }

    }
    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        if (index * 2 + 1 < arr.length){
            postOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length){
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);

    }


}

