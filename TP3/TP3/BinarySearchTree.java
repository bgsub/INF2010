import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() {
       // this.root = null;
    }

    // TODO: initialisation
    public BinarySearchTree(T item) {
      this.root  = new BinaryNode(item);

    }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) {
       root.insert(item);
    }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) {

        return root.contains(item); //this.root.contains(item);
    }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {

        return root.getHeight();
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {

        List<BinaryNode<T>> tempList = new ArrayList<>();
        root.fillListInOrder(tempList);
        return tempList;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
        StringBuilder inOrder = new StringBuilder("[");

       List<BinaryNode<T>> tempList = getItemsInOrder();

        for (int i = 0 ; i< tempList.size();i++) {
            if(tempList.get(i) !=null) {
                inOrder.append(tempList.get(i).getData());
                if( tempList.size()>i+1)
                    inOrder.append(", ");
                else break;
            }
        }
        inOrder.append("]");
        return inOrder.toString();
    }

}