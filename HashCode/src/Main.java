import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	    int a = 1;
	    int b = -1;
        System.out.println(((Integer)a).hashCode());
        System.out.println(((Integer)b).hashCode());
        String s = "cc";
        System.out.println(s.hashCode());

        Student student1 = new Student(3,1,"cc","w");
        System.out.println(student1.hashCode());
        Student student2 = new Student(3,1,"cc","w");
        System.out.println(student2.hashCode());
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student1);

        //在使用底层使用哈希表的数据结构时，要重写equals 和 hashCode方法。
        //保证在用自定义对象作为key时，两个对象如果相等，则hashMap.put 进行覆盖。
        //还有一点就是两个对象的hashCode相同，但是equals不相等。重写equals方法，为了保证key的唯一性。
        HashMap<Student,Integer> hashMap = new HashMap<>();
        hashMap.put(student1,100);
        hashMap.put(student2,101);

        System.out.println(hashMap.get(student1));
        System.out.println(hashMap.get(student2));
        System.out.println(student1.equals(student2));

    }
}
