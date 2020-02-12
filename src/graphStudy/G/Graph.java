package graphStudy.G;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 图结构类
 */

public class Graph {

	private int V; //节点的个数
	private int E; //所有节点之间边的个数
	private ArrayList<Edge> edges;
	private LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(String fileName) {
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File(fileName));

			V = scanner.nextInt();
			adj = new LinkedList[V];
			for(int i=0;i<V;i++) {
				adj[i] = new LinkedList<Integer>();
			}
			edges = new ArrayList<Edge>();
			E = scanner.nextInt();
			
			for(int i=0;i<E;i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();

				validateVertex(a);
				validateVertex(b);

				if(a==b) throw new IllegalArgumentException(String.format("存在自环边"));
				if(adj[a].contains(b)) throw new IllegalArgumentException(String.format("存在平行边"));

				edges.add(new Edge(a,b));
				adj[a].add(b);
				adj[b].add(a);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getV() {
		return V;
	}

	private void validateVertex(int v){
		if(v<0 || v>=getV())
			throw new IllegalArgumentException(String.format("Has No Vertex %d",v));
	}

	public boolean hasEdge(int v, int w){
		validateVertex(v);
		validateVertex(w);
		if(adj[v].contains(w)) return true;
		else return false;
	}

	public LinkedList<Integer> getNeighbor(int i){
		return adj[i];
	}

	public int getE() {
		return E;
	}

	public Iterable<Edge> getEdges(){
		return edges;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%d %d\n", V, E));
		for(int i=0;i<V;i++) {
			sb.append(String.format("%d : ",i));
			for(int w : adj[i]) {
				sb.append(String.format("%d ", w));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Graph adjList = new Graph("graphData/graph.txt");
		System.out.println(adjList.getEdges());

	}
}
