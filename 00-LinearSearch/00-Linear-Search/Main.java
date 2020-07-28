/**
 * 线性查找测试用例
 * @author robinson
 */
public class Main {
    public static void main(String[] args) {
        Integer[] data={14,24,35,8,56,34};
        int res = LinearSearch.search( data, 35);
        System.out.println(res);
        int res2=LinearSearch.search(data,77);
        System.out.println(res2);

        Student[] students={new Student("Lee"),new Student("Rey"),
                new Student("Alice")};
        Student rey=new Student("rey");
        int res3=LinearSearch.search(students,rey);
        System.out.println(res3);

        /**
         * performance test
         */
        int[] dataSize = {1000000, 10000000};
        for(int n: dataSize) {
            Integer[] array = ArrayGenerator.generateOrderArray(n);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(array,n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + "s");
        }

    }
}
