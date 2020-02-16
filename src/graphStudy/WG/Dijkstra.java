package graphStudy.WG;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    private WeightGraph weightGraph;
    private int source;
    private int[] distance;
    private boolean[] visited;

    private class Node implements Comparable{
        public int v, dis;
        public Node(int v, int dis){
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Node)
                return dis - ((Node) o).dis;
            throw new IllegalArgumentException(String.format("Error Of Object Type!"));
        }
    }
    public Dijkstra(WeightGraph weightGraph, int source){
        this.weightGraph = weightGraph;
        this.source = source;
        distance = new int[weightGraph.getV()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        visited = new boolean[weightGraph.getV()];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        priorityQueue.add(new Node(source, distance[source]));
        while (!priorityQueue.isEmpty()){

            int cur = priorityQueue.remove().v;
            if(visited[cur]) continue;
            visited[cur] = true;

            for (int w: weightGraph.getNeighbor(cur))
                if (!visited[w])
                    if (distance[cur] + weightGraph.getWeight(cur, w) < distance[w]){
                        distance[w] = distance[cur] + weightGraph.getWeight(cur, w);
                        priorityQueue.add(new Node(w, distance[w]));
                    }
        }
    }

    public boolean isConnectedTo(int w){
        weightGraph.validateVertex(w);
        return visited[w];
    }

    public int distanceTo(int w){
        weightGraph.validateVertex(w);
        return distance[w];
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("graphData/Graph.txt");
        Dijkstra dijkstra = new Dijkstra(weightGraph, 0);
        System.out.println(dijkstra.distanceTo(6));
    }
}
