package graphStudy.WG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BellmanFord {

    private WeightGraph weightGraph;
    private int source;
    private int[] dis;
    private int[] pre;
    private boolean hasNegativeCycle;

    public BellmanFord(WeightGraph weightGraph, int source){
        this.weightGraph = weightGraph;
        weightGraph.validateVertex(source);
        this.source = source;
        dis = new int[weightGraph.getV()];
        pre = new int[weightGraph.getV()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(pre, -1);
        dis[source] = 0;

        for (int i=0;i<weightGraph.getV();i++){

            for (int v=0;v<weightGraph.getV();v++)
                for (int w: weightGraph.getNeighbor(v))
                    if(dis[v]!=Integer.MAX_VALUE && dis[w]>dis[v] + weightGraph.getWeight(v, w)) {
                        dis[w] = dis[v] + weightGraph.getWeight(v, w);
                        pre[w] = v;
                    }
        }
        for (int v=0;v<weightGraph.getV();v++)
            for (int w: weightGraph.getNeighbor(v))
                if(dis[w]!=Integer.MAX_VALUE && dis[w]>dis[v] + weightGraph.getWeight(v, w))
                    hasNegativeCycle = true;
    }

    public boolean hasNegativeCycle(){
        return hasNegativeCycle;
    }

    public int distanceTo(int t){
        weightGraph.validateVertex(t);

        if (hasNegativeCycle==true)
            throw new RuntimeException("has hasNegativeCycle!");
        return dis[t];
    }

    public boolean isConnectedTo(int t){
        weightGraph.validateVertex(t);
        return dis[t] != Integer.MAX_VALUE;
    }

    public Iterable<Integer> findPath(int t){

        weightGraph.validateVertex(t);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (hasNegativeCycle==true)
            throw new RuntimeException("has hasNegativeCycle!");

        if (!isConnectedTo(t))
            return arrayList;

        while (t!=source){
            arrayList.add(t);
            t = pre[t];
        }
        arrayList.add(t);
        Collections.reverse(arrayList);

        return arrayList;
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("graphData/graph.txt");
        BellmanFord bellmanFord = new BellmanFord(weightGraph, 0);
        System.out.println(bellmanFord.findPath(2));
        System.out.println(bellmanFord.distanceTo(2));
        System.out.println("hasNegativeCycle: " + bellmanFord.hasNegativeCycle);
    }

}
