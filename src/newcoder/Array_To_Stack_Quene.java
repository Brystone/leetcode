package newcoder;

public class Array_To_Stack_Quene {
    public static class ArrayStack {
        private Integer[] arr;
        private int size;

        public ArrayStack (int initsize) {
            if (initsize < 0) {
                System.out.println("The init size less than 0");
            }
            arr = new Integer[initsize];
            size = 0; //栈内元素的索引
        }

        //元素进栈
        public void push (int obj) {
            if (arr.length == 0) {
                throw new ArrayIndexOutOfBoundsException("The quene is null");
            }
            //先赋值个arr[size] 然后size向上移动一个位置
             arr[size++] = obj;
        }

        //出栈
        public Integer pop() {
            if (arr.length == 0) {
                throw new ArrayIndexOutOfBoundsException("The quene is null");
            }
            return arr[--size];
        }
    }

    //用数组实现队列
    public static class ArrayQuene {
        private int start;
        private int end;
        private int size; //队列的大小
        private Integer[] arr;

        //构造方法初始化
        public ArrayQuene (int initsize) {
            if (arr==null) {
                System.out.println("The arr is null");
            }

            start = 0;
            end = 0;
            size = 0;
            arr = new Integer[size];
        }
        //元素入队
        public void push(int obj) {
            while (size == arr.length) {
                System.out.println("the arr is full");
            }
            size++;
            arr[end] = obj;//放到end位置
            end = end == arr.length-1 ? 0 : end++;
        }

        //元素出列,弹出的是start处的元素 队列是poll 栈是 push
        public Integer poll () {
            while (size == arr.length) {
                System.out.println("The arr is full");
            }
            size--;
            int temp = arr[start]; //用一个临时值存储start处的值
            start = start == arr.length ? 0 : start--;
            return temp;
        }

        //返回出队列的数，但不弹出
        public Integer peek() {
            //队列没有元素
            if (size == 0) {
                System.out.println("The quene is null");
            }
            return arr[start];
        }
    }
}


