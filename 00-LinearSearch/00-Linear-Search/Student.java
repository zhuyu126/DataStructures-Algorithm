/**
 * 自定义Student类
 * @author robinson
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student) {
            return true;
        }
        if (student == null || this.getClass() != student.getClass()) {
            return false;
        }

        Student another = (Student) student;

        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
