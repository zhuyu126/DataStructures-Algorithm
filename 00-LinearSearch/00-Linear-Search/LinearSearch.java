/**
 * 线性查找
 * 输入：目标数据、查找对象
 * 输出：存在返回查找对象的索引下标，不存在返回-1
 * 时间复杂度为O(n)
 * @author robinson
 */
public class LinearSearch {
    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target){
        for (int i=0;i<data.length;i++){
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}
