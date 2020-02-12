package graphStudy.WG;

public class WeightEdge implements Comparable{

    int v, w, weight;

    public WeightEdge(int v, int w, int weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightEdge{" +
                v +
                "-" +
                w +
                ": " +
                weight +
                '}';
    }

    @Override
    public int compareTo(Object another) {

        if (another instanceof WeightEdge)
            return weight - ((WeightEdge) another).weight;

        throw new IllegalArgumentException(String.format("Error Of Object Type!"));
    }
}
