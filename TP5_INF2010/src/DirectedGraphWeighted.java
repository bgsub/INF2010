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
        int index = 1;
        for (int i = 1; i < vertexCapacity; i++){
            Vertex vTemp = new Vertex(Integer.MAX_VALUE, index);
            vertices.add(vTemp);
            index+=1;
        }
        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;

            /*   Réponse question 1 partie 3:
             sachant qu'il s'agit d'un graphe orienté et que la méthode adj(Vertex) ne donne que la liste
                des sommets vers lequel se pointe le sommet choisit, nous pensons que le nombre d'itération sera de :

                 - 0 au minimum, si le sommet choisit est un sommet qui ne pointe vers aucun autre (Il n a pas de voisins vers lesquels il se dirrige); la
               raison est que l'attribut known de ce sommet sera mit à true avant la boucle et il n entrera pas dans la boucle.
                 - n au maximum, le nombre de sommets que le graphe peut avoir. En effet, si le sommet choisit et un sommet telle que
                 le sommet sur lequel il se dirige, pointe à son tour à un autre sommet jusqu'à ce que tous les sommets soit visité alors
                 l'algorithme va itérer autant de fois quMil y a de sommets dans le graphe.

             */
            for(Vertex w: adj(v.index)){
               /*
                      Réponse question 2 partie 3
                      Nous pensons que dans le pire cas, le nombre de modifications du cout sur chaque sommet sera m, la taille
                      de la liste de ses voisins
               */
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
                vertices.decreaseKey(w, v.cost+w.cost);
            }
        }
        /* Réponse question 3 partie 3:
        il y aura autant d'itérations qu'il y a de sommets dans, qu'ils soient null ou pas
         En effet , la boucle que nous avons implémenté considère tous les sommets dans le heap, et ignorent ceux qui sont null
          Donc pour:
           - 10 sommets, on aura 10 itérations
           - 100 sommets, on aura 100 itérations
           - 1000 sommets, on aura 1000 itérations */
        /*TODO Add up the total cost of the elements in the Heap */

        for(Vertex vTemp : vertices.Heap){
             totalCost += vTemp != null?vTemp.cost:0;
        }
        return totalCost;
    }
}