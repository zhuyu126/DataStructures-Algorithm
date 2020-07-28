/**
 * @author robinson
 */
public class ArrayGenerator {
    private ArrayGenerator() {
    }
    public static Integer[] generateOrderArray(int n){
        Integer[] arr = new Integer[n];
        for (int i=0;i<n;i++){
            arr[i]=n;
        }
        return arr;
    }
}
