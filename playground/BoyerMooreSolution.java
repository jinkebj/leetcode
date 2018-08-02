public class BoyerMooreSolution {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB AACDABABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(BoyerMoore.indexOf(str1, str2)); // should be 21
    }
}

class BoyerMoore {
    public static int indexOf(String txt, String pat) {
        int M = txt.length();
        int N = pat.length();

        // int[] right: the bad-character skip array
        int[] right = new int[ASCII_SIZE]; // position of rightmost occurrence of c in the pattern
        for (int i = 0; i < ASCII_SIZE; i++) right[i] = -1;
        for (int i = 0; i < pat.length(); i++) right[pat.charAt(i)] = i;

        int skip;
        for (int i = 0; i <= M - N; i += skip) {
            skip = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i; // found
        }
        return -1;
    }

    private static final int ASCII_SIZE = 256;
}
