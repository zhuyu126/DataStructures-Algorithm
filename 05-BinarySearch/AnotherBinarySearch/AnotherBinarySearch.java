public class AnotherBinarySearch {
    private AnotherBinarySearch() {
    }

    /**
     * 使用求解 >= target 的最小值索引的思路，实现 search
     * @param data 数组
     * @param target 目标
     * @param <E>
     * @return 在有序数组 data 中判断 target 是否存在，存在则返回相应索引，不存在则返回 -1
     */
    public static <E extends Comparable<E>>int search(E[] data,E target){
        int l=0,r=data.length;
        while (l<r){
            int mid=l+(r-l)/2;
            if (data[mid].compareTo(target)<0){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        // l 是 >= target 的最小值索引
        // 如果 data[l] == target，则返回 l；否则返回 -1
        // 注意，求解 >= target 的最小值索引，结果可能是 data.length，不是合法索引
        // 所以，我们要对 l 的合法性进行判断，即确定 l < data.length
        if (l<data.length && data[l].compareTo(target)==0){
            return l;
        }
        return -1;
    }
}
