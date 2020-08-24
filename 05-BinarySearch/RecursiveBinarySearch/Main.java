public class Main {
    public static void main(String[] args) {
        Integer[] data={8,14,24,34,35,56};
        int res=BinarySearch.searchR(data,34);
        int res2=BinarySearchNR.search(data,34);
        System.out.println(res);
        System.out.println(res2);
    }
}
