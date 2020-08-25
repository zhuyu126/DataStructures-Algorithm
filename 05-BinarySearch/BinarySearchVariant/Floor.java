/**
 * @author robinson
 */
public class Floor {
    private Floor() {
    }

    /**
     * 数组中存在 target 返回最大索引
     * 数组中不存在 target 返回lower
     * 即小于等于 target 的最大索引
     * @param data 数组
     * @param target 目标
     * @param <E> 泛型
     * @return 索引值
     */
    public static <E extends Comparable<E>>int upper_floor(E[] data,E target){
        int l=-1,r=data.length-1;
        while (l<r){
            int mid=l+(r-l+1)/2;
            if (data[mid].compareTo(target)<=0){
                l=mid;
            }else {
                r=mid-1;
            }
        }
        return l;
    }

    /**
     * 存在 target 返回最小索引
     * 不存在 target 返回lower
     * @param data 数组
     * @param target 目标
     * @param <E> 泛型
     * @return 索引值
     */
    public static <E extends Comparable<E>>int lower_floor(E[] data,E target){
        int l=Lower.lower(data,target);
        if (l+1<data.length && data[l+1].compareTo(target)==0){
            return l+1;
        }
        return l;
    }
}
