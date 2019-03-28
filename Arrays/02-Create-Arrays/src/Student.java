public class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        this.name = studentName;
        this.score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)",name,score);
    }

    /**
     * 验证自定义类型
     */
    public static void main(String[] args) {
        Arrays<Student> array=new Arrays<>();
        array.addLast(new Student("Alice",100));
        array.addLast(new Student("Tom",90));
        array.addLast(new Student("Ben",88));
        System.out.println(array);
    }
}
