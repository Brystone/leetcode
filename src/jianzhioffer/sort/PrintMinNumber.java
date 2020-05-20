package jianzhioffer.sort;
/*
将数组中的数字拼接，得到最小的一个数
 */
public class PrintMinNumber {
    private String printMinNumber(int[] numbers) {
        if (numbers.length == 0 || numbers == null) {
            return "";
        }
        // 3 2 怎么变成 2 3， 用空字符串拼接再转成整形
        String str = ""; //用于拼接
        //前后两个指针，3+""+2 --> "32" 和 "23"  将小的数放在数组前面
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                long a = Integer.valueOf(numbers[i]+""+numbers[j]);
                long b = Integer.valueOf(numbers[j]+""+numbers[i]);
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }
}
