package graph;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Yan
 * @create 2023-05-19 14:01
 **/
public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目
    //给定数组boolean[]，记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String vertex[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for(String vertexValue : vertex){
            graph.insertVertex(vertexValue);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,   1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
//        graph.showGraph();
//        graph.dfs();
        graph.bfs();
    }
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    //得到第一个邻接结点的下标w
    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size();j++){
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点

    /**
     *
     * @param v1 结点列
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for(int j = v2 + 1; j < vertexList.size();j++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    private void dfs(boolean[] isVisited,int i){
        //首先访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //节点i第一个邻接结点的下标w
        int w = getFirstNeighbor(i);
        while (w != -1){ // 说明有
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w节点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }
    //对dfs 进行一个重载，遍历我们所有的结点dfs
    public void dfs(){
        //遍历所有的节点，进行dfs【回溯】
        for(int i = 0; i < getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //对第一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i ){
        int u; //表示队列的头结点对应下标
        int w; //邻接结点w
        //队列，节点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        //访问节点，输出结点信息
        System.out.println(getValueByIndex(i)+"->");
        //标记已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u = queue.removeFirst();
            //得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w != -1){//找到了
                //是否访问过
                if(!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前去点，找w后面的下一个邻结点
                w = getNextNeighbor(u,w);//体现广度优先
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        for(int i = 0; i < getNumOfVertex(); i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //图中常用的方法
    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link : edges){
            System.err.println(Arrays.toString(link));
        }
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边

    /**
     *
     * @param v1 表示点的下标，第几个顶点
     * @param v2 第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges ++;
    }
}
