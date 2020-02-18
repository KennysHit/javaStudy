package graphStudy.WG;

public class WeightEdge implements Comparable{

    private int v;
    private int w;
    private int weight;

    public WeightEdge(int v, int w, int weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" +
                v +
                "-" +
                w +
                ": " +
                weight +
                ')';
    }

    @Override
    public int compareTo(Object another) {

        if (another instanceof WeightEdge)
            return weight - ((WeightEdge) another).weight;

        throw new IllegalArgumentException(String.format("Error Of Object Type!"));
    }

}
