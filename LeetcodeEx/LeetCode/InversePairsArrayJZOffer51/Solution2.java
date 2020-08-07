package InversePairsArrayJZOffer51;
/**
 * 剑指Offer
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 归并排序求解，归并操作的次数即为数组逆序数对的总数
 * @author robinson
 */

public class Solution2 {
    public int reversePairs(int[] nums) {
        int[] temp=new int[nums.length];
        return sort(nums,0,nums.length-1,temp);
    }
    private int sort(int[] array, int l, int r, int[] temp) {
        if (l>=r){
            return 0;
        }
        int mid=l+(r-l)/2;
        int res=0;
        res+=sort(array,l,mid, temp);
        res+=sort(array, mid+1, r, temp );
        if (array[mid]>array[mid+1]){
            res+=merge(array,l,mid,r,temp);
        }
        return res;
    }
    private int merge(int[] array, int l, int mid, int r, int[] temp) {
        System.arraycopy(array,l,temp,l,r-l+1);
        int i=l,j=mid+1,res=0;
        for (int k=l;k<=r;k++){
            if (i>mid){
                array[k]=temp[j];
                j++;
            }
            else if (j>r){
                array[k]=temp[i];
                i++;
            }else if (temp[i]<=temp[j]){
                array[k]=temp[i];
                i++;
            }else {
                res+=mid-i+1;
                array[k]=temp[j];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{7,5,6,4};
        Solution sl=new Solution();
        System.out.println(sl.reversePairs(nums));
    }
}
