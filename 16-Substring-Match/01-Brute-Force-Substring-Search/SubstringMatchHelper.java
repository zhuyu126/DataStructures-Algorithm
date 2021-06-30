public class SubstringMatchHelper {
    private SubstringMatchHelper(){}

    public static void matchTest(String name, String s, String t){

        int pos = -1;

        long startTime = System.nanoTime();
        if(name.equals("bruteforce")){
            pos = SubstringMatchByBruteforce.bruteforce(s, t);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(pos != -1 && !s.substring(pos, pos + t.length()).equals(t))
            throw new RuntimeException(name + " failed");
        System.out.println(String.format("%s : res = %d, time = %f s", name, pos, time));
    }

}
