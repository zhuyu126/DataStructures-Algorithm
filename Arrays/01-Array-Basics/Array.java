public class Array {
    public static void main(String[] args) {
        int[] arr=new int[10];//数组创建方式一：声明数组长度
        for (int i=0;i<arr.length;i++){
            arr[i]=i;
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        int [] scores=new int []{100,99,66};//数组创建方式二
        for(int i=0;i<scores.length;i++){//数组具有可遍历(可迭代)的特性
            System.out.print(scores[i]+"\t");
        }
        System.out.println();
        for(int score:scores){
            System.out.print(score+"\t");
        }
    }
}
