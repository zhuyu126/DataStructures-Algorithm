/**
 * LoopQueue test
 * @author robinson
 */
public class LoopQueueMain {
    public static void main(String[] args) {
        LoopQueue<Integer> queue=new LoopQueue<>();
        LoopQueueWithoutWastingOneCapacitySpace<Integer>queue1=new LoopQueueWithoutWastingOneCapacitySpace<>();
        LoopQueueWithoutSizeMember<Integer>queue2=new LoopQueueWithoutSizeMember<>();
        for(int i=0;i<10; i++){
            queue.enqueue(i);
            queue1.enqueue(i);
            queue2.enqueue(i);
            System.out.println("LoopQueue:"+queue);
            System.out.println("LoopQueueWithoutWastingOneCapacitySpace"+queue1);
            System.out.println("LoopQueueWithoutSizeMember:"+queue2);
            if(i%3==2){
                queue.dequeue();
                queue1.dequeue();
                queue2.dequeue();
                System.out.println("LoopQueue:"+queue);
                System.out.println("LoopQueueWithoutWastingOneCapacitySpace:"+queue1);
                System.out.println("LoopQueueWithoutSizeMember:"+queue2);
            }
        }
    }
}
