package leetcode.string;

/*
242. Valid Anagram 判断两个字符串的字符是否都相同，不要求顺序

思路：字符串是由26个组成，使用大小为26的数组，先将字符串变为字符，然后遍历字符数组放入数组中
使用ascii码当作数组的索引，nums[a - 'a']++ 表示 nums[0] = 1;
然后再遍历另一个字符数组，nums[a - 'a']--m 如果数组中的值为0，则表示两个字符串所有的字符都相同
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        //可以使用增强for循环，简化代码
        for (int i: s.toCharArray()) {
            arr[i - 'a']++;
        }
        for (int i: t.toCharArray()) {
            arr[i - 'a']--;
        }
        for (int i: arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
