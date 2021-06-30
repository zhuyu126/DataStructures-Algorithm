public class RabinKarpMain {
    public static void main(String[] args) {
        String s1 = "hello, this is liuyu.";
        String t1 = "yu";
        SubstringMatchHelper.matchTest("bruteforce", s1, t1);
        SubstringMatchHelper.matchTest("rk", s1, t1);

        String s2 = FileOperation.readFile("16-Substring-Match/pride-and-prejudice.txt");
        String t2 = "china";
        SubstringMatchHelper.matchTest("bruteforce", s2, t2);
        SubstringMatchHelper.matchTest("rk", s2, t2);

        SubstringMatchHelper.matchTest("bruteforce", s2, "zyx");
        SubstringMatchHelper.matchTest("rk", s2, "zyx");

        /// Worst case
        int n = 1000000, m = 10000;

        StringBuilder s3 = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            s3.append('a');
        }

        StringBuilder t3 = new StringBuilder();
        for(int i = 0; i < m - 1; i ++) {
            t3.append('a');
        }
        t3.append('b');

        SubstringMatchHelper.matchTest("bruteforce", s3.toString(), t3.toString());
        SubstringMatchHelper.matchTest("rk", s3.toString(), t3.toString());
    }
}
