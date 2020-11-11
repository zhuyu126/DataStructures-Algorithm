import java.util.Random;

public class Main {
    private static double testUF(UF uf,int m){
        int size=uf.getSize();
        Random random=new Random();
        long startTime=System.nanoTime();
        for (int i=0;i<m;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.unionElements(a,b);
        }
        for (int i=0;i<m;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.isConnected(a,b);
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        //QuickFind 慢于 QuickUnion
//        int size=100000;
//        int m=10000;
        //QuickUnion 慢于 QuickFind
        int size=10000000;
        int m=10000000;
        QuickFind quickFind=new QuickFind(size);
        System.out.println("QuickFind : " + testUF(quickFind, m) + " s");
        QuickUnion quickUnion=new QuickUnion(size);
        System.out.println("QuickUnion : " + testUF(quickUnion, m) + " s");
        UnionFindBySize unionFindBySize=new UnionFindBySize(size);
        System.out.println("UnionFindBySize : " + testUF(unionFindBySize, m) + " s");
        UnionFindByRank unionFindByRank=new UnionFindByRank(size);
        System.out.println("UnionFindByRank : " + testUF(unionFindByRank, m) + " s");
    }
}
