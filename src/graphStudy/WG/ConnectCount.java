package graphStudy.WG;

import java.util.ArrayList;

/**
 * 查找图的每个联通分量
 */
public class ConnectCount {

    private WeightGraph weightGraph;
    private int[] visited;
    private int count;

    public ConnectCount(WeightGraph weightGraph){
        this.weightGraph = weightGraph;
        visited = new int[weightGraph.getV()];

        for(int i=0;i<weightGraph.getV();i++)
            visited[i] = -1;

        count = 0;

        for (int i=0;i<weightGraph.getV();i++)
            if(visited[i]==-1) {
                dfs(i,count);
                count++;
            }
    }

    public void dfs(int source, int cid){
        visited[source] = cid;

        for (int w: weightGraph.getNeighbor(source))
            if(visited[w]==-1)
                dfs(w,cid);
    }

    public int getCount(){
        return count;
    }

    public ArrayList<Integer>[] getConnects(){
        ArrayList<Integer>[] result = new ArrayList[count];

        for (int i=0;i<count;i++)
            result[i] = new ArrayList<Integer>();

        for (int v=0;v<weightGraph.getV();v++)
            result[visited[v]].add(v);

        return result;
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("graph.txt");
        ConnectCount connectCount = new ConnectCount(weightGraph);

        for(int i=0;i<connectCount.getCount();i++)
            System.out.println(connectCount.getConnects()[i]);

    }
}
