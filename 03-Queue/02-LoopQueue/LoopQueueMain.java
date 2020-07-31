public class LoopQueueMain {
    public static void main(String[] args) {
        LoopQueue<Integer> queue=new LoopQueue<>();
        LoopQueueWithoutWastingOneCapacitySpace<Integer>queue1=new LoopQueueWithoutWastingOneCapacitySpace<>();
        for(int i=0;i<10; i++){
            queue.enqueue(i);
            queue1.enqueue(i);
            System.out.println("LoopQueue:"+queue);
            System.out.println("LoopQueueWithoutWastingOneCapacitySpace"+queue1);
            if(i%3==2){
                queue.dequeue();
                queue1.dequeue();
                System.out.println("LoopQueue:"+queue);
                System.out.println("LoopQueueWithoutWastingOneCapacitySpace"+queue1);
            }
        }
    }
}
