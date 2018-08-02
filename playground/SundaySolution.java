public class SundaySolution {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB AACDABABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(Sunday.indexOf(str1, str2)); // should be 21
    }
}

class Sunday {
    // totalStr为主串， partStr为模式串
    public static int indexOf(String totalStr, String partStr) {
        char[] total = totalStr.toCharArray();
        char[] part = partStr.toCharArray();
        int tSize = total.length;
        int pSize = part.length;

        int[] move = new int[ASCII_SIZE]; // 主串参与匹配最末位字符移动到该位需要移动的位数
        for (int i = 0; i < ASCII_SIZE; i++) move[i] = pSize + 1;
        for (int i = 0; i < pSize; i++) move[part[i]] = pSize - i;

        int s = 0; // 模式串头部在字符串位置
        int j; // 模式串已经匹配了的长度

        while (s <= tSize - pSize) { // 到达末尾之前
            j = 0;
            while (total[s + j] == part[j]) {
                j++;
                if (j >= pSize) return s;
            }
            s += move[total[s + pSize]];
        }
        return -1;
    }

    private static final int ASCII_SIZE = 256;
}
