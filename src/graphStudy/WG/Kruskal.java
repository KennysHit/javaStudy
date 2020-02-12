package graphStudy.WG;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    private WeightGraph weightGraph;
    private ArrayList<WeightEdge> minSpanTree;

    public Kruskal(WeightGraph weightGraph){
        this.weightGraph = weightGraph;
        minSpanTree = new ArrayList<WeightEdge>();

        ConnectCount connectCount = new ConnectCount(weightGraph);
        if(connectCount.getCount()>1) return;

        ArrayList<WeightEdge> weightEdges = new ArrayList<WeightEdge>();
        for(int v=0;v<weightGraph.getV();v++)
            for(int w: weightGraph.getNeighbor(v))
                if(v<w)
                    weightEdges.add(new WeightEdge(v, w, weightGraph.getWeight(v, w)));
        Collections.sort(weightEdges);

    }

    public Iterable<WeightEdge> getMinSpanTree(){
        return minSpanTree;
    }

    public static void main(String[] args) {

    }

}
