package InversePairsArrayJZOffer51;

/**
 * 剑指Offer
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */

/**
 * 双指针解法
 * leetcode 测试超时
 */
class Solution {
    public int reversePairs(int[] nums) {
        int res=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    res++;
                }
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
