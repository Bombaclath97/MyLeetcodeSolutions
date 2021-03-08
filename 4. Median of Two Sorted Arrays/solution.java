class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        median = (nums1.length == 0 || nums2.length == 0) ?
            checkOneArray(nums1.length == 0 ? nums2 : nums1) : checkBothArrays(nums1, nums2);
        return median;
    }

    private double checkBothArrays(int[] nums1, int[] nums2) {
        double median = 0.0d;
        int medianValueIndex = nums1.length + nums2.length;
        boolean incrementedFirstIterator = false;
        //we now split into the two cases: even or odd elements?
        if(medianValueIndex % 2 == 0) {
            for(int i = 0, j = 0; i + j < (medianValueIndex / 2) + 1;) {
                //Step 1: are we in the first median value? Translates to: is i + j equal to total elements / 2 + 1?
                if((i + j) == (medianValueIndex / 2) - 1) {
                    median += (nums1[i] <= nums2[j]) ? (double) nums1[i] : (double) nums2[j]; 
                }
                //Step 2: are we in the second median value?
                else if((i + j) == medianValueIndex/2) {
                    median += (nums1[i] <= nums2[j]) ? (double) nums1[i] : (double) nums2[j]; 
                }
                //Step 3: let's increment either i or j
                if(nums1[i] <= nums2[j] && i <= nums1.length - 1 && !incrementedFirstIterator) {
                    i++;
                    incrementedFirstIterator = true;
                } 
                else if(incrementedFirstIterator); //TODO: FIX THIS S-WORD
            }
            //We have our median sum, let's now divide it by 2!
            median /= 2.0d;
        } else {
            for(int i = 0, j = 0; i + j < Math.round(medianValueIndex / 2) + 1;) {
                //Do we have our value? Is i + j equal to total element / 2 rounded down?
                if((i + j) == Math.round(medianValueIndex / 2)) {
                    median += (nums1[i] <= nums2[j]) ? (double) nums1[i] : (double) nums2[j]; 
                }
                if(nums1[i] <= nums2[j] && i < nums1.length - 1) i++;
                else j++;
            }
        }
        return median;
    }

    private double checkOneArray(int[] nums) {
        int lengthOfArray = nums.length;
        double median = lengthOfArray % 2 == 0 ? (double) nums[(lengthOfArray / 2) - 1] + (double) nums[(lengthOfArray / 2)] : (double) nums[Math.round(lengthOfArray / 2)];
        median /= 2.0d;
        return median;
    }
}