import java.util.Random;

/**
 * BST测试用例代码
 */
public class Mains {
    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        Random random=new Random();
        int n=10;
        //int[] nums={5,3,7,9,4,2};
        //int[] nums={60,40,30,50,80,70,90};
        for(int i=0;i<10;i++){
            bst.add(random.nextInt(100));
        }
//        for(int n:nums){
//            bst.add(n);
//        }
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();

        System.out.println();
        System.out.println(bst);
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.inOrderNR();
        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.postOrderNR();
        System.out.println();
        bst.levelOrder();
        System.out.println(bst.maxmun());
        System.out.println(bst.minimum());
        bst.removeMin();
        System.out.println(bst);
        bst.remove(60);
        System.out.println(bst);
    }
}
