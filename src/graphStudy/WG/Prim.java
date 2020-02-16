package graphStudy.WG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

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
        Queue<WeightEdge> queue = new PriorityQueue<WeightEdge>();

        for(int w: weightGraph.getNeighbor(0))
            queue.add(new WeightEdge(0, w, weightGraph.getWeight(0, w)));

        while (!queue.isEmpty()){
            WeightEdge minWeightEdge = queue.remove(); //在优先队列中每次remove()会去除最小的成员
            if(visited[minWeightEdge.getV()] && visited[minWeightEdge.getW()])
                continue;
            minSpanTree.add(minWeightEdge);
            int newv = visited[minWeightEdge.getV()] ? minWeightEdge.getW() : minWeightEdge.getV();
            visited[newv] = true;

            for (int w: weightGraph.getNeighbor(newv))
                if(!visited[w])
                    queue.add(new WeightEdge(newv, w, weightGraph.getWeight(newv, w)));
        }

    }

    public Iterable<WeightEdge> getMinSpanTree(){
        return minSpanTree;
    }


    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("graphData/graph.txt");
        Prim prim = new Prim(weightGraph);
        System.out.println(prim.getMinSpanTree());
    }

}
