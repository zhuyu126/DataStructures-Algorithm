import java.util.Random;

public class QueuesComparison {

    //测试使用q运行opCount个enqueue和dequeue操作需要的时间，单位：秒
    private static double testQueue(Queue<Integer>q, int opCount){
        long startTime=System.nanoTime();
        //...
        Random random=new Random();
        for(int i=0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0;i<opCount;i++){
            q.dequeue();
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int opCount=100000;//操作数量
        ArrayQueue<Integer>arrayQueue=new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue time:"+time1+"s");//主要的耗时部分是数组队列出队对数组执行的删除操作

        LoopQueue<Integer>loopQueue=new LoopQueue<>();
        double time2=testQueue(loopQueue,opCount);
        System.out.println("LoopQueue time:"+time2+"s");
    }
}
