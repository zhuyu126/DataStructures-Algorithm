/**
 * 大于 target 目标的最小值索引
 * @author robinson
 */
public class Upper {
    private  Upper() {
    }
    public static <E extends Comparable<E>>int upper(E[] data,E target){
        int l=0,r=data.length;
        //在 data[l, r] 中寻找解
        while(l<r){
            int mid=l+(r-l)/2;
            if (data[mid].compareTo(target)<=0){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }
}
