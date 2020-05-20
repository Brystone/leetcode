package newcoder;

import com.sun.javaws.jnl.LibraryDesc;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class DogCatQuene {
    /*
    宠物类：成员变量 type 宠物的类型
     */
    public static class Pet {
        private String type;

        public Pet (String type) {
            this.type = type;
        }

        //给获取方法
        public String getType() {
            return type;
        }

        public void eat() {
            System.out.println("eat");
        }
    }

    public static class Dog extends Pet {
        public Dog () { //子类访问父类带参构造方法时，使用super关键字，且出现在第一行
            super("Dog");
        }
    }

    public static class Cat extends Pet {
        public Cat () {
            super("Cat");
        }
    }

    /*
    宠物进类
    成员：宠物 Pet pet //
         计数器 int count
         带参构造方法
         get pet count 方法
     */
    public static class PetEnter {
        private Pet pet;// 哪种动物 值是地址
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        //获取队列中宠物类型
        public String getEnterPetType () {
            return this.pet.getType();
        }
    }

    /*
    猫狗队列 成员变量 Quene<PetEnter> //类型是队列，里面存放的是 宠物进类 类型（引用类型）
                   count
     */
    public static class DogCatQuene1 {
        private Queue<PetEnter> dogQ; //变量名字是首字母小写 宠物进的队列
        private Queue<PetEnter> catQ;
        private long count; // ？？

        //队列可以用 双向链表表示
        public DogCatQuene1() {
            this.dogQ = new LinkedList<PetEnter>();
            this.catQ = new LinkedList<PetEnter>();
            this.count = 0;
        }

        public void add(Pet pet) {
            if (pet.getType().equals("Dog")) {
                this.dogQ.add(new PetEnter(pet, count++));
            } else if (pet.getType().equals("Cat")) {
                this.catQ.add(new PetEnter(pet, count++));
            } else {
                throw new RuntimeException("not dog not cat");
            }
        }

        //弹出队列中所有的实例 peek() 方法返回队列首个元素
        public Pet allPoll () {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {  //？为什么要用 peek() 方法
                    return this.dogQ.poll().getPet();
                } else {
                    return catQ.poll().getPet();
                }
             } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return catQ.poll().getPet();
            } else {
                throw new RuntimeException("err");
            }
        }

        public Dog dogPoll() {
            if (!this.dogQ.isEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("dog is empty");
            }
        }

        public Cat catPoll() {
            if (!this.catQ.isEmpty()) {
                return (Cat) this.catQ.poll().getPet(); //弹出的是pet类型，猫继承了pet，可以向下转换
            } else {
                throw new RuntimeException("cat is empty");
            }
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean dogIsEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean catIsEmpty() {
            return this.catQ.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQuene1 test = new DogCatQuene1();
        //加入的是子类
        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        //猫队列不为空，则出队列
        while (!test.catIsEmpty()) {
            System.out.println(test.catPoll().getType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.allPoll().getType());
        }
    }
}
