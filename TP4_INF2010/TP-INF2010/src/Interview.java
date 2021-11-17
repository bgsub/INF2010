import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {


      /*
      *   La complexité de poll() étant log n, et celle de peek et add() étant 1, on a avec la boucle while
      * une complexité de n *(log(n) + log(n) +1)  = n log(n)
      *
      * ajouter chaque element de boxes dans le heap se fait avec une complexité de n
      *
      * Ce qui donne au finale pour la methode lastBox, une complexité totale de C =O (nlog(n))
      * */
        public int lastBox(int[] boxes){
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
            int firstHeavyBox;
            int secondHeavyBox;
            for( int box: boxes)
            {
                 heap.add(box);
            }
             while(heap.size()>1)
             {
                 firstHeavyBox = heap.poll();
                 if(heap.peek()!=null)
                 secondHeavyBox = heap.poll();
                 else return firstHeavyBox;
                 if(firstHeavyBox!=secondHeavyBox) heap.add(Math.abs(secondHeavyBox-firstHeavyBox));
             }
            if(heap.size() ==0) return 0;
            return heap.peek();
        }
}


