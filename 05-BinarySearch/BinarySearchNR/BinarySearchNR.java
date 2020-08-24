public class BinarySearchNR {
    private BinarySearchNR() {
    }
    public static <E extends Comparable<E>> int search(E[] data, E target){
        int l=0,r=data.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if (data[mid].compareTo(target)==0){
                return mid;
            }
            if (data[mid].compareTo(target)<0){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }
}
