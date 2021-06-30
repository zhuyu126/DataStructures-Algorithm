public class BruteforceMain {
    public static void main(String[] args) {
        String s = FileOperation.readFile("16-Substring-Match/pride-and-prejudice.txt");
        String t = "china";
        SubstringMatchHelper.matchTest("bruteforce", s, t);

        SubstringMatchHelper.matchTest("bruteforce", s, "zyx");

        /// Worst case
        int n = 1000000, m = 1000;

        StringBuilder s1 = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            s1.append('a');
        }

        StringBuilder t1 = new StringBuilder();
        for(int i = 0; i < m - 1; i ++) {
            t1.append('a');
        }
        t1.append('b');

        SubstringMatchHelper.matchTest("bruteforce", s1.toString(), t1.toString());
    }
}
