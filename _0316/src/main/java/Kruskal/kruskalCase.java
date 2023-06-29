package Kruskal;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-06-10 11:31
 **/
public class kruskalCase {
    //边的个数
    private int edgeNum;
    //顶点数组
    private char[] vertexs;
    //邻接矩阵
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        kruskalCase kruskalCase = new kruskalCase(vertexs, matrix);
//        kruskalCase.print();
//        EData[] edges = kruskalCase.getEdges();
//        System.out.println(Arrays.toString(edges));
//        System.out.println("排序后--------------");
//        kruskalCase.sortEdges(edges, 0,edges.length-1);
//        System.out.println(Arrays.toString(edges));
        kruskalCase.kruskal();
    }

    public kruskalCase(char[] vertexs, int[][] matrix){
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        System.arraycopy(vertexs, 0, this.vertexs, 0, vlen);
        this.matrix = new int[vlen][vlen];
        for(int i = 0 ; i < vlen;i++){
            for(int j = 0 ; j < vlen;j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for(int i = 0 ; i < vlen;i++){
            for(int j = i+1; j < vlen; j++){
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }

    }
    public void kruskal(){
        //表示最后结果数组的索引
        int index = 0;
        //保存已有最小生成树 中每一个顶点在最小生成树中的重点
        int[] ends = new int[edgeNum];
        //创建结果数组，保存最后的最小生成树
        EData[] results = new EData[edgeNum];
        EData[] edges = getEdges();
        sortEdges(edges,0,edgeNum-1);
        //遍历edges数组，将边添加到最小生成树中，判断是准备加入的边是否构成回路，如果没有，则加入，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有最小生成树的终点
            int m = getEnd(ends,p1);
            //获取p2这个顶点在已有最小生成树的终点
            int n = getEnd(ends,p2);
            //是否构成回路
            if (m != n){
                ends[m] = n;
                results[index++] = edges[i];
            }
        }
        //最小生成树为
        for (int i = 0 ; i < index;i++){
            System.out.println(results[i]);
        }
    }

    public void print(){
        for(int i = 0 ; i < vertexs.length;i++){
            for (int j = 0 ; j < vertexs.length;j++){
                System.out.printf("%d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }
    private void sortEdges(EData[] edges,int left,int right){
        int pivot = edges[(left + right) / 2].weight;
        int l = left;
        int r = right;
        EData temp;
        while (l < r){
            while(edges[l].weight < pivot){
                l++;
            }
            while(edges[r].weight > pivot){
                r--;
            }
            if (l >= r){
                break;
            }
            temp = edges[l];
            edges[l] = edges[r];
            edges[r] = temp;
            if (edges[l].weight == pivot){
                r--;
            }
            if (edges[r].weight == pivot){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            sortEdges(edges,l,right);
        }
        if (r > left){
            sortEdges(edges,left,r);
        }
    }

    /**
     *
     * @param ch 顶点的值 ‘A’ 'B'
     * @return 返回对应的下标
     */
    private int getPosition(char ch){
        for(int i = 0; i < vertexs.length; i++){
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，后面需要遍历该数组
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     * @param ends:记录了各个顶点对应的终点是那个，是在遍历过程中逐步形成的
     * @param i ： 表示传入的顶点对应的下标
     * @return 返回的就是下标为i的这个顶点对应的重点的下标
     */
    private int getEnd(int[] ends, int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

}

class EData{
    char start;
    char end;
    int weight;

    public EData(char start , char end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String   toString() {
        return "EData{" +
                "<" + start +
                "," + end +
                ">,=" + weight +
                '}';
    }

}

