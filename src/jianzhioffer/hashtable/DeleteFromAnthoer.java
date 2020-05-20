package jianzhioffer.hashtable;

/*
删除一个字符串包含另一个字符串的字符
 */
public class DeleteFromAnthoer {
    private String deleteFromAnthoer(String str, String anthoer) {
        if (str == null || anthoer == null || str.length() == 0 || anthoer.length() == 0) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        //用布尔数组标记另一个字符串
        boolean[] flag = new boolean[256];
        //遍历另一个字符串
        for (int i=0; i<anthoer.length(); i++) {
            flag[anthoer.charAt(i)] = true;
        }
        //遍历要删除的字符串
        for (int i=0; i<str.length(); i++) {
            if (!flag[str.charAt(i)]) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
