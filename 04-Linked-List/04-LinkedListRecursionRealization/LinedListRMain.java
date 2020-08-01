public class LinedListRMain {
    public static void main(String[] args) {
        LinkedListRecursion<Integer> list = new LinkedListRecursion<>();
        for(int i = 0 ; i < 10 ; i ++) {
            list.addFirst(i);
        }
        System.out.println(list);
        System.out.println("listSize:"+list.getSize());
        while(!list.isEmpty()) {
            list.removeLast();
            System.out.println("removed:" + list);
        }
    }
}
