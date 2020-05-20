package newcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OverideComparator {
        public static class Student {
            public  String name;
            public  int age; //不可定义为静态变量
            public  int id;

            public Student(String name, int age, int id) { //构造方法
                this.name = name;
                this.age = age;
                this.id = id;
            }
        }

        //按照id升序排序的类，实现系统比较器的接口
        public static class IdAscendingComparator implements Comparator<Student> {
            @Override
            //重写比较方法，参数是学生对象，
            public int compare(Student od1, Student od2) {
                //前面小返回负数 等于返回0 大 返回1
                return od1.id - od2.id;
            }
        }

        //测试比较器
        public static void main(String[] args) {
            Student s1 = new Student("s", 18, 22);
            Student s2 = new Student("a", 20, 21);
            Student s3 = new Student("c", 12, 33);

            //把3个学生对象放到数组中去
            Student[] students = new Student[] {s1, s2, s3}; //对数组进行静态初始化
            Arrays.sort(students, new IdAscendingComparator()); //一个比较器，匿名对象
            printStudents(students);
            System.out.println("--------------");
            //优先队列
            PriorityQueue<Student> heap = new PriorityQueue<Student>(new IdAscendingComparator()); //放入比较器

            //入列
            heap.add(s1);
            heap.add(s2);
            heap.add(s3);

            while (!heap.isEmpty()) {
                //出列
               Student student =  heap.poll();
               System.out.println("id:"+student.id + "age:"+student.age + "name:"+student.name);
            }
        }

        public static void printStudents(Student[] students) {
            for (Student stu: students) {
                System.out.println("id:" + stu.id + "name:" + stu.name + "age:"+ stu.age);
            }
        }


}
