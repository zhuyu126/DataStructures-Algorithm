public class DequeMain {
    public static void main(String[] args) {
        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for(int i = 0 ; i < 16 ; i ++){
            if(i % 2 == 0) {
                dq.addLast(i);
            } else {
                dq.addFirst(i);
            }
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for(int i = 0; !dq.isEmpty(); i ++){
            if(i % 2 == 0) {
                dq.removeFirst();
            } else {
                dq.removeLast();
            }
            System.out.println(dq);
        }
    }
}
