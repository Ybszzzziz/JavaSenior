package Hanoit;

/**
 * @author Yan
 * @create 2023-06-13 17:09
 **/
public class hanoiTower {

    public static void main(String[] args) {
        hanoi(5,'A','B','C');

    }

    public static void hanoi(int num, char a,char b, char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从 " + a + " ->"+ c);
        }else {
            //如果有n>=2 的情况，可以看作是两个盘1.最下边的一个盘2，上面的所有盘
            //1.先把最上面的所有盘A->B，移动过程会使用到C
            hanoi(num-1,a,c,b);
            //2.最下边的盘A -> C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3.把B塔的所有盘从B->C，移动过程使用A塔
            hanoi(num-1,b,a,c);

        }
    }

}
