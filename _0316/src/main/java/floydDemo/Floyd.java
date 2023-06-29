package floydDemo;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-06-13 21:48
 **/
public class Floyd {
    static final int INF = 65535;
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,5,7,INF,INF,INF,2},
                {5,0,INF,9,INF,INF,3},
                {7,INF,0,INF,8,INF,INF},
                {INF,9,INF,0,INF,4,INF},
                {INF,INF,8,INF,0,5,4},
                {INF,INF,INF,4,5,0,6},
                {2,3,INF,INF,4,6,0}
        };
        Graph graph = new Graph(vertex.length,matrix,vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph{
    //顶点的数组
    private char[] vertex;
    //保存从各个顶点出发到其他顶点的距离
    private int[][] dis;
    //保存到达目标顶点的前驱节点
    private int[][] pre;

    /**
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        //初始化pre数组 , 存放的是前驱顶点的下标
        for (int i = 0 ; i < length; i++){
            Arrays.fill(pre[i],i);
        }
    }

    public void show(){
        char[] vertex = {'A','B','C','D','E','F','G'};
        for(int k = 0; k < dis.length; k++){
            for (int i = 0 ; i < dis.length; i++){
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            for(int j = 0 ; j < dis.length; j++){
                System.out.print("("+vertex[k]+"到"+vertex[j]+"的最短路径是" + dis[k][j] + ") ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void floyd(){
        int len = 0;
        //对中间顶点遍历，k就是中间顶点的下标
        for( int k = 0 ; k < dis.length; k++){
            //从i顶点开始出发 ABCDEFG
            for (int i = 0 ; i < dis.length; i++){
                for (int j = 0 ; j < dis.length; j++){
                    //求出从i顶点出发经过k中间顶点到达j顶点的距离
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]){
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }

}
