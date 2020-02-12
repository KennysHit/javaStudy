package graphStudy.WG;

/**
 * 并查集
 */
public class UnionFind {

    private int[] parent;
    private int[] weight;

    public UnionFind(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[i] = 1;
        }
    }

    public int find(int element) {

        while (element != parent[element])
            element = parent[element];

        return element;
    } //查找某点的集合

    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    } //判断两点是否属于同一个集合

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);

        //如果已经属于同一个集合了，就不用再合并了。
        if (firstRoot == secondRoot)
            return;

        if (weight[firstRoot] > weight[secondRoot]) {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        } else {//weight[firstRoot] <= weight[secondRoot]
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        }
    } //合并两个集合

    public int[] getParent(){
        return parent;
    }

    public void printArr(int[] arr){
        for(int p : arr)
            System.out.print(p+"\t");

        System.out.println();
    }

}