import java.util.Arrays;

public class SQRTNumArray {
    private int[] data,blocks;//数据及区间块数
    private int N;//元素总数
    private int B;//每组区间的元素数
    private int BN;//组数

    public SQRTNumArray(int[] nums){
        N=nums.length;
        if (N==0){
            return;
        }
        B= (int) Math.sqrt(N);
        BN=N/B+(N%B>0?1:0);
        data= Arrays.copyOf(nums,N);
        blocks=new int[BN];
        for (int i=0;i<N;i++){
            blocks[i/B]+=nums[i];
        }
    }
    public int sumRange(int l,int r){
        if (l<0||l>=N||r<0||r>=N||l>r){
            return 0;
        }
        int bStart=l/B,bEnd=r/B;
        int res=0;
        if (bStart==bEnd){
            for (int i=l;i<=r;i++){
                res+=data[i];
            }
            return res;
        }
        for (int i=l;i<(bStart+1)*B;i++){
            res+=data[i];
        }
        for (int b=bStart+1;b<bEnd;b++){
            res+=blocks[b];
        }
        for (int i=bEnd*B;i<=r;i++){
            res+=data[i];
        }
        return res;
    }

    public void update(int i,int value){
        if (i<0||i>=N){
            return;
        }
        int b=i/B;
        blocks[b]-=data[i];
        blocks[b]+=value;
        data[i]=value;
    }
}
