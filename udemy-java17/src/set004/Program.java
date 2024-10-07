package set004;

import set004.entities.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Student> courseA = new HashSet<>();
        Set<Student> courseB = new HashSet<>();
        Set<Student> courseC = new HashSet<>();
        Set<Student> students = new HashSet<>();

        System.out.print("How many students for course A? ");
        int nStudents = sc.nextInt(); sc.nextLine();
        for (int i = 1; i <= nStudents; i++) {
            System.out.printf("ID #%d ", i);
            courseA.add(new Student(sc.nextInt()));
            sc.nextLine();
        }

        System.out.print("How many students for course B? ");
        nStudents = sc.nextInt(); sc.nextLine();
        for (int i = 1; i <= nStudents; i++) {
            System.out.printf("ID #%d ", i);
            courseB.add(new Student(sc.nextInt()));
            sc.nextLine();
        }

        System.out.print("How many students for course C? ");
        nStudents = sc.nextInt(); sc.nextLine();
        for (int i = 1; i <= nStudents; i++) {
            System.out.printf("ID #%d ", i);
            courseC.add(new Student(sc.nextInt()));
            sc.nextLine();
        }

        students.addAll(courseA);
        students.addAll(courseB);
        students.addAll(courseC);
        System.out.printf("Total students: %d", students.size());

    }
}
