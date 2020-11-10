import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words=new ArrayList<>();
        if (FileOperation.readFile( "10-Trie/pride-and-prejudice.txt",words)){
            long startTime = System.nanoTime();
            BSTSet<String>set=new BSTSet<>();
            for(String word:words){
                set.add(word);
            }
            for (String word:words){
                set.contains(word);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");
            System.out.println("--------");

             startTime = System.nanoTime();
            Trie trie=new Trie();
            for(String word:words){
                trie.add(word);
            }
            for (String word:words){
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");


            System.out.println("--------");

            startTime = System.nanoTime();
            TrieR trieR=new TrieR();
            for(String word:words){
                trieR.addR(word);
            }
            for (String word:words){
                trieR.containsR(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trieR.getSize());
            System.out.println("TrieR: " + time + " s");
        }
    }
}
