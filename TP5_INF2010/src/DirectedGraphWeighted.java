import java.util.HashSet;

public class DirectedGraphWeighted {
    public HashSet<Vertex>[] neighbours;
    public int vertexCapacity;
    public int edgeQuantity;

    public void initialize(int numNodes) {
        this.vertexCapacity = numNodes;
        edgeQuantity = 0;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet();
    }

    public void connect(int v1, Vertex vertex){
        if(v1 < 0 || v1 >= vertexCapacity) return; /*Si v1 n'est pas un sommet du graphe, return*/
        if(vertex.index < 0 || vertex.index >= vertexCapacity) return; /*Si vertex n'est pas un sommet du graphe, return*/
        if( neighbours[v1].contains(vertex) ) return; /*Si v1 est deja connecter a vertex, return*/
        neighbours[v1].add(vertex);
        edgeQuantity++;
    }

    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(vertexCapacity).append(ln).append(edgeQuantity).append(ln);
        for(int v = 0; v < vertexCapacity; v++)
            for(Vertex w : neighbours[v])
                o.append(v).append("-").append(w.index).append(" Cost: ").append(w.cost).append(ln);
        return o.toString();
    }

    public HashSet<Vertex> adj(int v) {
        return v < 0 || v >= vertexCapacity ? null:neighbours[v];
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(vertexCapacity + 1);
        /* NE PAS MODIFIER CE CODE */

        /* TODO Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value for an integer */

        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
            }
        }

        /*TODO Add up the total cost of the elements in the Heap */

        return totalCost;
    }
}