public class Main {
    public static void main(String[] args) {
        Integer[] data={8,14,24,34,35,56};
        int res=BinarySearch.searchR(data,34);
        int res2=BinarySearchNR.search(data,34);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(Upper.upper(data,13));
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for(int i = 0; i <= 6; i ++) {
            System.out.print(Upper.upper(arr, i) + " ");
        }
        System.out.println();
    }
}
