package graphStudy.WG;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 最小生成树
 */
public class Prim {
    private WeightGraph weightGraph;
    private boolean[] visited;
    private ArrayList<WeightEdge> minSpanTree;

    public Prim(WeightGraph weightGraph){
        this.weightGraph = weightGraph;
        minSpanTree = new ArrayList<WeightEdge>();

        ConnectCount connectCount = new ConnectCount(weightGraph);
        if(connectCount.getCount()>1) return; //    如果该图不联通，则不存在最小生成树

        ArrayList<WeightEdge> weightEdges = new ArrayList<WeightEdge>();

        //Prim
        visited = new boolean[weightGraph.getV()];
        visited[0] = true;
        for(int i=0;i<weightGraph.getV()-1;i++){
            WeightEdge minWeightEdge = new WeightEdge(0, 0, Integer.MAX_VALUE);

            for(int v=0;v<weightGraph.getV();v++)
                if(visited[v])
                    for(int w: weightGraph.getNeighbor(v))
                        if(!visited[w] && weightGraph.getWeight(v, w)<minWeightEdge.getWeight())
                            minWeightEdge = new WeightEdge(v, w, weightGraph.getWeight(v, w));

            minSpanTree.add(minWeightEdge);
            visited[minWeightEdge.getW()] = true;
            visited[minWeightEdge.getV()] = true;
        }

    }

    public Iterable<WeightEdge> getMinSpanTree(){
        return minSpanTree;
    }


    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph();
        Prim prim = new Prim(weightGraph);
        System.out.println(prim.getMinSpanTree());
    }

}
