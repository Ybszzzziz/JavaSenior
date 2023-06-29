package horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Yan
 * @create 2023-06-14 8:45
 **/
public class HorseChessBoard {
    //棋盘的列数
    private static int X;
    //棋盘的行数
    private static int Y;
    //标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    //使用一个属性标记是否期盼的所有位置都被访问过
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard,row - 1,column-1,1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("=================");
        for(int[] rows : chessboard){
            for (int step : rows){
                System.out.print(step+" ");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param chessboard 棋盘
     * @param row 马儿当前的位置的行 从0开始
     * @param column 马儿当前的位置的列 从0开始
     * @param step 是第几步，初始位置为第1步
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step){
        chessboard[row][column] = step;
        visited[row * X + column] = true;
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()){
            //取出下一个可以走的位置
            Point p = ps.remove(0);
            //判断该点是否被访问过
            if (!visited[p.y * X + p.x]){
                traversalChessboard(chessboard,p.y,p.x,step+1);
            }
        }
        //判断马尔是否完成任务，使用step和应该走的步数比较
        //如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        // step < X * Y的情况有两种
        //1.棋盘到目前为止 仍然没有走完
        //2.棋盘处于一个回溯过程
        if (step < X * Y && !finished){
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        }else{
            finished = true;
        }

    }



    /**
     *  根据当前的位置，计算马儿还能走哪些位置，并放入集合中
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint){

        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        //5
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        //6
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        //7
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        //0
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        //1
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }
        //2
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        //3
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        //4
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1)  < Y){
            ps.add(new Point(p1));
        }
        return ps;
    }

    //根据当前这个一步的所有的下一步的选择位置，进行非递减排序
    //减少回溯的可能
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取到o1的下一步的所有位置的个数
                int count1 = next(o1).size();
                //获取到o2的下一步的所有位置个数
                int count2 = next(o2).size();
                if (count1 < count2){
                    return -1;
                }else if (count1 == 2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }


}
