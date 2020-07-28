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
    }
}
