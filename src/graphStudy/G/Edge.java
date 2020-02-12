package graphStudy.G;

public class Edge {

    int v, w;

    public Edge(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                v +
                "-" +
                w +
                '}';
    }
}
