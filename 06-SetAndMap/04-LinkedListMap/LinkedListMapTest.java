import java.util.ArrayList;

public class LinkedListMapTest {
    public static void main(String[] args) {
        System.out.println("pride-and-prejudice.txt");

        ArrayList<String>words=new ArrayList<>();
        if(FileOperation.readFile("06-SetAndMap/pride-and-prejudice.txt",words)){
            System.out.println("Total words:"+words.size());

            LinkedListMap<String,Integer> map=new LinkedListMap<>();
            for(String word:words){
                if(map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }
}
