import java.util.*;

public class Heap<ValueType extends Comparable<? super ValueType>> implements Iterable<ValueType> {

        public ArrayList<ValueType> elements;
        private final boolean isMax;

        public int size() {
            return elements.size() - 1;
        }

        @Override
        public Iterator<ValueType> iterator() {
            return elements.listIterator(1);
        }

        public Heap(boolean isMax, Collection<ValueType> elements) {
            // Ne pas modifier ces lignes
            this.isMax = isMax;
            this.elements = new ArrayList<>();
            this.elements.add(null);
            this.elements.addAll(elements);
            // Ne pas modifier ces lignes
            buildHeap();
        }

        /* TODO Implementer le compare pour un MaxHeap et MinHeap */
        protected boolean compare(ValueType first, ValueType second) {
            if(isMax) return first.compareTo(second) < 0;
            return first.compareTo(second) > 0;
        }

        /* TODO Retourner l'index du parent */
        public int parentIndex(int index) {
            return index/2;
        }

        /* TODO Retourner l'enfant gauche du noeud */
        public int leftChildIndex(int index) {
            return 2*index;
        }

        /* TODO Retourner l'enfant droit du noeud */
        public int rightChildIndex(int index) {
            return 2*index+1;
        }

        /* TODO Retourner si l'index present est une feuille */
        public boolean isLeaf(int pos) {
            return pos <= size() && pos >= size() / 2 + 1;
        }

        /* TODO Constuire le monceau avec les noeuds dans "elements" */
        // O(N)
        public void buildHeap() {
            for (int i = size() / 2; i > 0; i--) {
                percolateDown(i);
            }
        }

        /* TODO Echanger les elements qui se retrouve aux indexes currentIndex et parentIndex */
        private void swap(int currentIndex, int parentIndex) {
            ValueType temp = elements.get(currentIndex);
            elements.set(currentIndex, elements.get(parentIndex));
            elements.set(parentIndex, temp);
        }

        /* TODO Ajouter un element dans le monceaux. */
        // O(logN)
        public void insert(ValueType value) {
            elements.add(value);
            for(int i = size(); elements.get(i/2).compareTo(value) > 0; i /= 2) {
                swap(i/2, i);
            }
        }

        /* TODO Completer l'implementation des conditions de percolateDown pour un heap */
        // O(logN)
        private void percolateDown(int index) {
            int child;
            ValueType temp = elements.get(index);
            for(; index * 2 < size(); index = child) {

                child = index * 2;

                if(child != size() && compare(elements.get(child), elements.get(child+1))) {
                    child++;
                }

                if(compare(temp, elements.get(child))) {
                    elements.set(index, elements.get(child));
                }
                else
                    break;
            }
            elements.set(index, temp);
        }

        /* TODO En utilisant leftChildIndex, ajouter les elements gauche du Heap dans une liste et les retourner. */
        public List<ValueType> getLeftElements() {
            ArrayList<ValueType> AllLeftElements = new ArrayList<>();
            for(int i = 1; 2*i <= size(); i++) {
                AllLeftElements.add(elements.get(2*i));
            }
            return AllLeftElements;
        }

        /* TODO En utilisant rightChildIndex, ajouter les droites du Heap dans une liste et les retourner. */
        public List<ValueType> getRightElements() {
            ArrayList<ValueType> AllRightElements = new ArrayList<>();
            for(int i = 1; 2*i+1 <= size(); i++) {
                AllRightElements.add(elements.get(2*i+1));
            }
            return AllRightElements;
        }

        /* TODO En utilisant parentIndex, ajouter les noeuds  parents du Heap dans une liste et les retourner. */
        public List<ValueType> getParentElements() {
            ArrayList<ValueType> AllParents = new ArrayList<>();
            for(int i = 1; 2*i <= size(); i++) {
                AllParents.add(elements.get(i));
            }
            return AllParents;
        }

        /* TODO Ajouter les noeuds feuilles du monceau en utilisant isLeaf */
        public List<ValueType> getLeaves() {
            ArrayList<ValueType> Leaves = new ArrayList<>();
            for (int i = 0; i <= size(); i++) {
                if(isLeaf(i)) Leaves.add(elements.get(i));
            }
            return Leaves;
        }

}