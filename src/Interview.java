import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {

        //Time complexite est de O(nlogn)
        public int lastBox(int[] boxes){

            // Ne pas modifier la ligne suivante
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

            for (int box:boxes) heap.add(box); //O(nlogn)
            return lastBox(heap);//O(nlogn)
        }

        private int lastBox(PriorityQueue<Integer> heap){
            if(heap.size() == 0) return 0;
            if(heap.size() == 1) return heap.poll();

            //Collision
            Integer box2 = heap.poll();
            Integer box1 = heap.poll();
            if(!box1.equals(box2)) heap.add(box2-box1);//O(logn)
            return lastBox(heap);
        }
}


