public class Arrays {

    private int[] data;
    private int size;//data数组中的有效大小

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数组容量
     */
    public Arrays(int capacity){
        data=new int[capacity];
        size=0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity为10
     */
    public Arrays(){
        this(10);
    }

    /**
     *获取数组中的元素个数
     * @return 数组中的元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return 数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否空
    public boolean isEmpty(){
        return size==0;
    }
}
