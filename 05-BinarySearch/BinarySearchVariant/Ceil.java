/**
 * @author robinson
 */
public class Ceil {
    private Ceil() {
    }

    /**
     * target 不存在数组中返回upper
     * target 存在数组中 返回最大索引
     * @param data 数组
     * @param target 目标数据
     * @param <E> 泛型
     * @return 索引值
     */
    public static <E extends Comparable<E>>int upper_ceil(E[] data,E target){
        int u=Upper.upper(data,target);
        if (u-1>=0 && data[u-1].compareTo(target)==0){
            return u-1;
        }
        return u;
    }

    /**
     * target 不存在数组中返回upper
     * target 存在数组中 返回最小索引
     * 即大于等于 target 目标的最小值索引
     * @param data 数组
     * @param target 目标数据
     * @param <E> 泛型
     * @return 索引值
     */
    public static <E extends Comparable<E>>int lower_ceil(E[] data,E target){
        int l=0,r=data.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if (data[mid].compareTo(target)<0){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }
}
