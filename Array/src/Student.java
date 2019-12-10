/**
 * @Author: cc
 * @Date: 2019/12/10 10:57
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)",this.name,this.score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("cc",100));
        arr.addLast(new Student("cc1",99));
        arr.addLast(new Student("cc2",98));
        System.out.println(arr);
    }
}
