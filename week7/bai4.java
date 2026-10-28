import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

class Student implements Comparator<Student> {
    private int id;
    private String name;
    private double gpa;

    public Student() {
        id = 0;
        name = "";
        gpa = 0.0;
    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public double getGpa() { return this.gpa; }
    @Override
    public String toString(){
        return getName();
    }
    @Override
    public int compare(Student a, Student b) {
        if (a.getGpa() != b.getGpa())
            return Double.compare(b.getGpa(), a.getGpa());
        if (!a.getName().equals(b.getName()))
            return a.getName().compareTo(b.getName());
        return Integer.compare(a.getId(), b.getId());
    }
}
public class bai4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Student> pq = new PriorityQueue<>(new Student());
        int q = sc.nextInt();
        while (q-- > 0){
            String tp = sc.next();
            switch (tp){
                case "ENTER":
                    String name = sc.next();
                    double gpa = sc.nextDouble();
                    int id = sc.nextInt();
                    pq.add(new Student(id, name, gpa));
                    break;
                case "SERVED":
                    if (!pq.isEmpty()) pq.poll();
                    break;
                default:
                    break;
            }
        }
        if (pq.isEmpty()){
            System.out.print("EMPTY");
            return;
        }
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
