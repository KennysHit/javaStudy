package graphStudy.WG;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 带权图结构类
 */

public class WeightGraph {

    private int V; //节点的个数
    private int E; //所有节点之间边的个数
    private ArrayList<WeightEdge> weightEdges;
    private TreeMap<Integer, Integer>[] adj;

    @SuppressWarnings("unchecked")
    public WeightGraph(String fileName) {
        Scanner scanner1;
        File file = new File(fileName);
        try {
            scanner1 = new Scanner(file);
            V = scanner1.nextInt();
            adj = new TreeMap[V];
            weightEdges = new ArrayList<WeightEdge>();
            E = scanner1.nextInt();

            for(int i=0;i<V;i++)
                adj[i] = new TreeMap<Integer, Integer>();

            for(int i=0;i<E;i++) {
                int a = scanner1.nextInt();
                int b = scanner1.nextInt();
                validateVertex(a);
                validateVertex(b);
                int weight = scanner1.nextInt();

                if(a==b)
                    System.out.println("存在自环边");

                if(adj[a].containsKey(b))
                    System.out.println("存在平行边");

                weightEdges.add(new WeightEdge(a, b, weight));
                adj[a].put(b, weight);
                adj[b].put(a, weight);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public int getV() {
        return V;
    }

    public Iterable<Integer> getNeighbor(int i){
        return adj[i].keySet();
    }

    public int getE() {
        return E;
    }

    public int getWeight(int v, int w){
        if (hasEdge(v, w))
            return adj[v].get(w);
        else
            throw new IllegalArgumentException(String.format("Has No Edge:%d-%d", v, w));
    }

    private boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);

        if(adj[v].containsKey(w))
            return true;
        else
            return false;
    }

    public void validateVertex(int v){
        if(v<0 || v>=getV())
            throw new IllegalArgumentException(String.format("has no vertex %d",v));
    } //检验顶点名称的合法性

    private Iterable<WeightEdge> getWeightEdges(){
        return weightEdges;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %d\n", V, E));

        for(int i=0;i<V;i++) {
            sb.append(String.format("%d : ",i));
            Iterator<Integer> iterator = adj[i].keySet().iterator();

            while(iterator.hasNext()){
                Integer key = iterator.next();
                sb.append(String.format("(%d: %d), ", key, adj[i].get(key)));
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
       WeightGraph weightGraph = new WeightGraph("graphData/graph.txt");
       System.out.println(weightGraph.getWeight(0, 1));
    }

}
