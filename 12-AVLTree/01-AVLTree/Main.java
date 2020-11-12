import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("12-AVLTree/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

//            Collections.sort(words);

            //test BST
            long startTime = System.nanoTime();
            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }
            for(String word: words) {
                bst.contains(word);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");

            System.out.println("------------");
            //test AVL
            startTime = System.nanoTime();
            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word)) {
                    avl.set(word, avl.get(word) + 1);
                } else {
                    avl.add(word, 1);
                }
            }
            for(String word: words) {
                avl.contains(word);
            }
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");

            System.out.println("Total different words: " + avl.getSize());
            System.out.println("Frequency of PRIDE: " + avl.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + avl.get("prejudice"));
            System.out.println("is BST : " + avl.isBST());
            System.out.println("is Balanced : " + avl.isBalanced());
            for(String word: words){
                avl.remove(word);
                if(!avl.isBST() || !avl.isBalanced()) {
                    throw new RuntimeException();
                }
            }
        }

        System.out.println();
    }
}
