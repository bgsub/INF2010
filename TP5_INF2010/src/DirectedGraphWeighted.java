import java.util.HashSet;

public class DirectedGraphWeighted {
    private HashSet<Vertex>[] neighbours;
    private int nodeCapacity;
    private int graphConnections;

    /* TODO Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        this.nodeCapacity = numNodes;
        graphConnections = 0;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet();
    }

    /*TODO Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, int v2, Vertex vertex){
        if(v1 < 0 || v1 >= nodeCapacity) return; /*Voir si v1 est un sommet du graphe */
        if(v2 < 0 || v2 >= nodeCapacity) return; /*Voir si v2 est un sommet du graphe */
        if( neighbours[v1].contains(vertex) ) return; /*Voir si v1 est deja connecter a v2*/
        neighbours[v1].add(vertex);
        graphConnections++;
    }

    /* TODO Print all the edges connecting vertices*/
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(nodeCapacity).append(ln).append(graphConnections).append(ln);
        for(int v = 0; v < nodeCapacity; v++)
            for(Vertex w : neighbours[v])
                o.append(v).append("-").append(w.index).append(" Cost: ").append(w.cost).append(ln);
        return o.toString();
    }

    /* TODO Return a HashMap of adjacent edges / vertices */
    public HashSet<Vertex> adj(int v) {
        return v < 0 || v >= nodeCapacity ? null:neighbours[v];
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(nodeCapacity + 1);
        /* TODO Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value */
        /* NE PAS MODIFIER CE CODE */

        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* TODO Evaluate each edge to see if the total cost is less than the cost contained in nodes. */
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
            }
        }

        /*TODO Add up the total cost of the elements in the Heap */

        return totalCost;
    }
}