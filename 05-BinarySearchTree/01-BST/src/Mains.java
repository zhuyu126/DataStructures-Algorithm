/**
 * BST测试用例代码
 */
public class Mains {
    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        int[] nums={5,3,7,9,4,2};
        for(int num:nums){
            bst.add(num);
        }
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
    }
}
