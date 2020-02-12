package graphStudy.WG;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 最小生成树
 */
public class Kruskal {

    private WeightGraph weightGraph;
    private ArrayList<WeightEdge> minSpanTree;

    public Kruskal(WeightGraph weightGraph){
        this.weightGraph = weightGraph;
        minSpanTree = new ArrayList<WeightEdge>();

        ConnectCount connectCount = new ConnectCount(weightGraph);
        if(connectCount.getCount()>1) return; //    如果该图不联通，则不存在最小生成树

        ArrayList<WeightEdge> weightEdges = new ArrayList<WeightEdge>();

        for(int v=0;v<weightGraph.getV();v++)
            for(int w: weightGraph.getNeighbor(v))
                if(v<w)
                    weightEdges.add(new WeightEdge(v, w, weightGraph.getWeight(v, w)));

        Collections.sort(weightEdges);

        UnionFind unionFind = new UnionFind(weightGraph.getV());
        for (WeightEdge weightEdge: weightEdges) {
            int v = weightEdge.getV();
            int w = weightEdge.getW();
            if (!unionFind.isConnected(v, w)) {
                unionFind.unionElements(v, w);
                minSpanTree.add(weightEdge);
            }
        }
    }

    public Iterable<WeightEdge> getMinSpanTree(){
        return minSpanTree;
    }


    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph();
        Kruskal kruskal = new Kruskal(weightGraph);
        System.out.println(kruskal.getMinSpanTree());
    }

}
