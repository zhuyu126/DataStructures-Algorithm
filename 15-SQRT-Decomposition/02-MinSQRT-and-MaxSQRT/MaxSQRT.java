import java.util.Arrays;

/**
 * 使用 SQRT 分解解决区间最大值查询
 */
public class MaxSQRT {
    private int[] data,blocks;//数据及区间块数
    private int N;//元素总数
    private int B;//每组区间的元素数
    private int BN;//组数

    public MaxSQRT(int[] nums) {
        N=nums.length;
        if (N==0){
            return;
        }
        B= (int) Math.sqrt(N);
        BN=N/B+(N%B>0?0:1);
        data= Arrays.copyOf(nums,N);
        blocks=new int[BN];
        Arrays.fill(blocks,Integer.MIN_VALUE);
        for (int i=0;i<N;i++){
            blocks[i/B]=Math.min(blocks[i/B],nums[i]);
        }
    }

    /**
     * 区间最小值查询
     * @param l
     * @param r
     * @return
     */
    public int maxRange(int l,int r){
        if (l<0||l>=N||r<0||r>=N||l>r){
            return 0;
        }
        int bStart=l/B,bEnd=r/B;
        int res=Integer.MIN_VALUE;
        if (bStart==bEnd){
            for (int i=l;i<=r;i++){
                res=Math.max(res,data[i]);
            }
            return res;
        }
        for (int i=l;i<(bStart+1)*B;i++){
            res=Math.max(res,data[i]);
        }
        for (int b=bStart+1;b<bEnd;b++){
            res = Math.max(res, blocks[b]);
        }
        for (int i=bEnd*B;i<=r;i++){
            res=Math.max(res,data[i]);
        }
        return res;
    }
    public void update(int index,int value){
        if (index<0||index>=N){
            return;
        }
        int b=index/B;
        data[index]=value;
        blocks[b]=Integer.MIN_VALUE;
        for (int i = b * B; i < Math.min((b + 1) * B, N); i ++){
            blocks[b]=Math.max(blocks[b],data[i]);
        }
    }
}
