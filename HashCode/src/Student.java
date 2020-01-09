import java.util.Objects;

/**
 * @Author: ck
 * @Date: 2020/1/9 22:21
 */
public class Student {
    private int grade;
    private int cls;
    private String firstName;
    private String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass() )
            return false;
        if (o == this)
            return true;

        Student another = (Student) o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName == another.firstName &&
                this.lastName == another.lastName;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student)) return false;
//        Student student = (Student) o;
//        return grade == student.grade &&
//                cls == student.cls &&
//                firstName.equals(student.firstName) &&
//                lastName.equals(student.lastName);
//    }

    @Override
    public int hashCode() {
        int B = 31;

        int hash = 1;
        hash = hash*B+grade;
        hash = hash*B+cls;
        hash = hash*B+firstName.hashCode();
        hash = hash*B+lastName.hashCode();
        return hash;
    }
}
