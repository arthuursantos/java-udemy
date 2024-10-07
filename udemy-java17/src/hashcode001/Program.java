package hashcode001;

public class Program {
    public static void main(String[] args) {
        Student s1 = new Student(37388, "Arthur Santos");
        Student s2 = new Student(38376, "Pedro Silveira");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
    }
}
