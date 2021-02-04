import java.util.Arrays;
import java.util.Objects;

/**
 * 通用的SQRT实现
 */
public class SQRTDecomposition<E> {
    private E[] data,blocks;//数据及区间块数
    private int N;//元素总数
    private int B;//每组区间的元素数
    private int BN;//组数
    private Merger<E> merger;

    public SQRTDecomposition(E[] array,Merger<E> merger) {
        this.merger = merger;
        N=array.length;
        if (N==0){
            return;
        }
        B= (int) Math.sqrt(N);
        BN=N/B+(N%B>0?1:0);
        data= (E[]) new Object[N];
        for (int i=0;i<N;i++){
            data[i]=array[i];
        }
        blocks= (E[]) new Object[BN];
        for (int i=0;i<N;i++){
            if (i%B==0){
                blocks[i/B]=data[i];
            }
            else {
                blocks[i/B]=merger.merge(blocks[i/B],data[i]);
            }
        }
    }
    public E queryRange(int l,int r){
        if (l<0||l>=N||r<0||r>=N||l>r){
            return null;
        }
        int bStart=l/B,bEnd=r/B;
        E res=data[l];
        if (bStart==bEnd){
            for (int i=l+1;i<=r;i++){
                res=merger.merge(res,data[i]);
            }
            return res;
        }
        for (int i=l+1;i<(bStart+1)*B;i++){
            res=merger.merge(res,data[i]);
        }
        for (int b=bStart+1;b<bEnd;b++){
            res=merger.merge(res,blocks[b]);
        }
        for (int i=bEnd*B;i<=r;i++){
            res=merger.merge(res,data[i]);
        }
        return res;
    }
    public void update(int index,E value){
        if (index<0||index>=N){
            return;
        }
        int b=index/B;
        data[index]=value;
        blocks[b]=data[b*B];
        for (int i = b * B; i < Math.min((b + 1) * B, N); i ++){
            blocks[b]=merger.merge(blocks[b],data[i]);
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        // 针对Integer类型 区间和 SQRT 分解
        SQRTDecomposition<Integer> sumSQRT = new SQRTDecomposition<>(arr, (a, b)-> a + b);
        // 针对Float类型 区间最大值 SQRT 分解
        SQRTDecomposition<Integer> maxSQRT = new SQRTDecomposition<>(arr, (a, b)-> Math.max(a, b));
        //针对String类型 区间最小值 SQRT 分解
        SQRTDecomposition<Integer> minSQRT = new SQRTDecomposition<>(arr, (a, b)-> Math.min(a, b));
    }
}
