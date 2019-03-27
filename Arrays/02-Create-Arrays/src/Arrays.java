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

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(int e){
        add(size,e);
    }
    //向所有元素前添加一个新元素
    public void addFirst(int e){
        add(size,e);
    }

    /**
     * 在第index个位置插入一个新元素
     * @param index 插入位置
     * @param e 插入元素
     */
    public void add(int index,int e){
        if(size==data.length){
            throw new IllegalArgumentException("Add failed.Array is full.");
        }else if(index<0||size<index){
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<=size.");
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
}
