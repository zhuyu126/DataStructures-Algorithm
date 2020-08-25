/**
 *  target 不存在数组中返回upper
 *  target 存在数组中 返回最大索引
 * @author robinson
 */
public class Ceil {
    private Ceil() {
    }
    public static <E extends Comparable<E>>int ceil(E[] data,E target){
        int u=Upper.upper(data,target);
        if (u-1>=0 && data[u-1].compareTo(target)==0){
            return u-1;
        }
        return u;
    }
}
