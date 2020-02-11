package graphStudy;

import java.util.ArrayList;
import java.util.Collections;

public class HamiltonLoopDFS {

    private Graph graph;
    private boolean[] visited;
    private int[] pre;

    public HamiltonLoopDFS(Graph graph) {
        // TODO Auto-generated constructor stub
        this.graph = graph;
        visited = new boolean[graph.getV()];
        pre = new int[graph.getV()];
        for(int i=0;i<graph.getV();i++) {
            visited[i] = false;
        }

        dfs(0,0);
    }

    private void dfs(int source, int parent) {
        visited[source] = true;
        pre[source] = parent;
        for(int w: graph.getNeighbor(source)) {
            if(!visited[w]) {
                dfs(w, source);
            }else if(w==0 && allVisited()){
                pre[w] = source;
            }
        }
        visited[source] = false;
    }

    private boolean allVisited(){
        for(boolean w: visited){
            if(w==false)return false;
        }
        return true;
    }

    public Iterable<Integer> getResult(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(pre[0]==0) return null;

        int curr = 0;
        for(int i=0;i<graph.getV();i++){
            result.add(pre[curr]);
            curr = pre[curr];
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graphData/graph.txt");
        HamiltonLoopDFS hamiltonLoop = new HamiltonLoopDFS(graph);
        System.out.println(hamiltonLoop.getResult());
    }
}
