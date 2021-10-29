import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data)
    {
        this.data = data;
        this.right =null;
        this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData()
    {

        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item)
    {
       BinaryNode<T> node = new BinaryNode<>(item);
       if(node.data.compareTo(this.data)<=0)
       {
            if(this.left ==null)
            {
                this.left = node;
            }
            else left.insert(node.data);
       }
        if(node.data.compareTo(this.data)>0)
        {
            if(this.right ==null)
            {
                this.right = node;
            }
            else right.insert(node.data);
        }

    }


    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
          if(item==null)
              return false;

        if(item.compareTo(this.data)<0)
        {
            if(left == null)
                return false;
            return left.contains(item);
        }
        if(item.compareTo(this.data)>0)
        {
            if(right == null)
                return false;
             return right.contains(item);
        }
        else return true;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        int leftHeight = (left==null? 0: 1+ left.getHeight());
        int rightHeight = (right==null? 0: 1+ right.getHeight());
        return Math.max(leftHeight ,rightHeight) ;
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        if(this.left!=null)
            this.left.fillListInOrder(result);
        result.add(new BinaryNode<>(data));
        if(this.right!=null)
            this.right.fillListInOrder(result);
    }

}