public class Arrays<E> {

    private E[] data;
    private int size;//data数组中的有效大小

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数组容量
     */
    public Arrays(int capacity){
        data=(E[])new Object[capacity];
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
     * 向所有元素后添加一个新元素 时间复杂度则变为O(n)
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }
    //向所有元素前添加一个新元素 时间复杂度则变为O(n)
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个新元素 时间复杂度则变为O(n)
     * @param index 插入位置
     * @param e 插入元素
     */
    public void add(int index,E e){
        if(size==data.length){//动态数组
            // throw new IllegalArgumentException("Add failed. Array is full");
            resize(2*data.length);
        }else if(index<0||size<index){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * 获取index 索引位置的元素 时间复杂度则变为O(n)
     * @param index 索引
     * @return 元素
     */
    E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素e 时间复杂度则变为O(n)
     * @param index 索引位置
     * @param e 修改值
     */
    void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index]=e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e 查找元素
     * @return
     */
    public boolean contanins(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组元素e所在的索引，如果不存在元素e 返回-1 时间复杂度则变为O(n)
     * @param e 查找元素e
     * @return 如果不存在元素e 返回-1,否则返回索引
     */
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素 时间复杂度则变为O(n)
     * @param index 索引
     * @return 删除元素
     */
    public E remove (int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        E ret=data[index];
//        for( ;index<size;index++){
//            data[index]=data[index+1];
//        }
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;//loitering objects!=memory leak
        if(size==data.length /4 &&data.length/2!=0){//使用Lazy方式解决复杂度震荡
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 删除第一个元素 时间复杂度则变为O(n)
     * @return 删除元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素 时间复杂度则变为O(n)
     * @return 删除元素
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除指定一个元素 时间复杂度则变为O(n)
     * @param e
     */
    public void removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Arrays:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 动态数组扩容 时间复杂度则变为O(n)
     * @param newCapacity 扩容大小
     */
    private void resize(int newCapacity){
        E[] newData= (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
}
