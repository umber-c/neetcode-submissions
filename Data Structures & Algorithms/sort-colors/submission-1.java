class Solution {
    public void sortColors(int[] nums) {
        int k = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            } else {
                i++;
            }
        }
    }
}