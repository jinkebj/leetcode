public class BruteForceSolution {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB AACDABABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(BruteForce.indexOf(str1, str2)); // should be 21
    }
}

class BruteForce {
    public static int indexOf(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置

        while (i < t.length && j < p.length) {
           if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
               i++;
               j++;
           } else {
               i = i - j + 1; // 一旦不匹配，i后退
               j = 0; // j归0
           }
        }

        if (j == p.length) {
           return i - j;
        } else {
           return -1;
        }
    }
}
