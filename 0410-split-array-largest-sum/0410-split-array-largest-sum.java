class Solution {
    public int splitArray(int[] nums, int k) {
        int left = nums[0];
        int right = 0;
        for(int i : nums ){
            left = Math.max(left,i);
            right += i;
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            if(splitCount(nums,mid) > k){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }

    public static int splitCount(int [] nums,int mid){
        int count = 1;
        int cur = 0;
        for(int i = 0;i< nums.length;i++){
            if(cur + nums[i] <= mid){
                cur += nums[i];
            }
            else{
                count++;
                cur = nums[i];
            }
        }
        return count;
    }
}

//tc: nlog(sum)
//sc: 1