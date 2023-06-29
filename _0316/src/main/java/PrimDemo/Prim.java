package PrimDemo;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-06-09 19:57
 **/
public class Prim {

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,9,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
//        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);

    }

}

class MinTree{
    //创建图的邻接矩阵

    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        int i,j;
        for(i = 0; i < verxs;i++){
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }

    }
    public void showGraph(MGraph graph){
        for(int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *
     * @param graph 图
     * @param v 从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v){
        //visited标记结点是否被访问过
        int[] visited = new int[graph.verxs];
        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE;
        //因为有graph.verxs顶点，prim结束后，有graph.verxs-1条边
        for(int k = 1; k < graph.verxs; k++){

            //确定每一次生成的子图，和那个结点的距离最近
            //i结点表示被访问过的节点
            for (int i = 0; i < graph.verxs; i++) {
                //j结点表示还没有被访问过的节点
                for (int j = 0; j < graph.verxs;j++){
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        //替换minWeight
                        //寻找已经访问过的节点和为访问过的结点之间最小的边
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小的
            System.out.println("<"+graph.data[h1]+","+graph.data[h2]+">"+" "+minWeight);
            //将h2标记已经访问，minWeight重设为最大值
            visited[h2] = 1;
            minWeight = Integer.MAX_VALUE;
        }

    }
}

class MGraph{
    int verxs; // 表示图节点个数
    char[] data;//存放节点数据
    int[][] weight; //邻接矩阵

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
