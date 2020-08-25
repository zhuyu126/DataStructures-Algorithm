/**
 * 小于target的最大值
 * @author robinson
 */
public class Lower {
    private Lower() {
    }

    /**
     * 小于 target 的最大值索引
     * @param data 数组
     * @param target 目标
     * @param <E> 泛型
     * @return 索引值
     */
    public static <E extends Comparable<E>>int lower(E[] data,E target){
        int l=-1,r=data.length-1;
        // 在 data[l, r] 中寻找解
        while(l<r){
            int mid=l+(r-l+1)/2;
            if (data[mid].compareTo(target)<0){
                l= mid;
            }else {
                r=mid-1;
            }
        }
        return l;
    }
}
