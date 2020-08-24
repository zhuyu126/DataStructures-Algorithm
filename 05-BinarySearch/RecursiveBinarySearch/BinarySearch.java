public class BinarySearch {
    private BinarySearch() {
    }
    public static <E extends Comparable<E>> int searchR(E[] data, E target){
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target){
        if(l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if(data[mid].compareTo(target) == 0) {
            return mid;
        }
        if(data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }
        return searchR(data, l, mid - 1, target);
    }
}
